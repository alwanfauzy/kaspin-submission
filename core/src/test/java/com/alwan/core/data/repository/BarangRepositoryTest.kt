import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import com.alwan.core.di.local.datasource.BarangLocalDataSource
import com.alwan.core.data.mapper.BarangMapper
import com.alwan.core.data.repository.BarangRepositoryImpl
import com.alwan.core.domain.repository.BarangRepository
import com.alwan.core.util.Dummy
import com.alwan.core.util.MainDispatcherRule
import com.alwan.core.util.getOrAwaitValue
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class BarangRepositoryTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var barangLocalDataSource: BarangLocalDataSource

    private lateinit var barangMapper: BarangMapper
    private lateinit var barangRepository: com.alwan.core.domain.repository.BarangRepository

    @Before
    fun setUp() {
        barangMapper = BarangMapper()
        barangRepository = BarangRepositoryImpl(barangLocalDataSource, barangMapper)
    }

    @Test
    fun `getAllBarang() should return list of barang`() = runTest {
        val dummyListBarangEntities = Dummy.generateListBarangEntities()
        val dummyListBarang = barangMapper.mapEntitiesToDomains(dummyListBarangEntities)

        val expected = flowOf(dummyListBarangEntities)
        `when`(barangLocalDataSource.getAllBarang()).thenReturn(expected)

        val actual = barangRepository.getAllBarang().asLiveData().getOrAwaitValue()

        verify(barangLocalDataSource).getAllBarang()
        assertEquals(dummyListBarang.size, actual.size)
        assertEquals(dummyListBarang[0], actual[0])
        assertEquals(dummyListBarang[0].code, actual[0].code)
        assertEquals(dummyListBarang[0].name, actual[0].name)
        assertEquals(dummyListBarang[0].description, actual[0].description)
        assertEquals(dummyListBarang[0].price, actual[0].price)
        assertEquals(dummyListBarang[0].stock, actual[0].stock)
        assertEquals(dummyListBarang[0].imageUrl, actual[0].imageUrl)
    }

    @Test
    fun `getBarangById() should return Barang with id requested`() = runTest {
        val barangId = "barangId"
        val dummyBarangEntity = Dummy.generateBarangEntity()
        val dummyBarang = barangMapper.mapEntityToDomain(dummyBarangEntity)

        val expected = flowOf(dummyBarangEntity)
        `when`(barangLocalDataSource.getBarangById(barangId)).thenReturn(expected)

        val actual = barangRepository.getBarangById(barangId).asLiveData().getOrAwaitValue()

        verify(barangLocalDataSource).getBarangById(barangId)
        assertEquals(dummyBarang, actual)
        assertEquals(dummyBarang.code, actual.code)
        assertEquals(dummyBarang.name, actual.name)
        assertEquals(dummyBarang.description, actual.description)
        assertEquals(dummyBarang.price, actual.price)
        assertEquals(dummyBarang.stock, actual.stock)
        assertEquals(dummyBarang.imageUrl, actual.imageUrl)
    }
}