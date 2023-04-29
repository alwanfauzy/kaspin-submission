package com.alwan.barangku.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alwan.barangku.presentation.main.MainViewModel
import com.alwan.barangku.util.MainDispatcherRule
import com.alwan.core.domain.usecase.BarangUseCase
import com.alwan.core.util.Dummy
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

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var barangUseCase: com.alwan.core.domain.usecase.BarangUseCase

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel(barangUseCase)
    }

    @Test
    fun `getAllBarang() should return list of barang`() = runTest {
        val dummyListBarang = Dummy.generateListBarangs()

        val expected = flowOf(dummyListBarang)
        `when`(barangUseCase.getAllBarang()).thenReturn(expected)

        val actual = mainViewModel.getAllBarang().getOrAwaitValue()

        verify(barangUseCase).getAllBarang()
        assertEquals(dummyListBarang.size, actual.size)
        assertEquals(dummyListBarang[0], actual[0])
        assertEquals(dummyListBarang[0].code, actual[0].code)
        assertEquals(dummyListBarang[0].name, actual[0].name)
        assertEquals(dummyListBarang[0].description, actual[0].description)
        assertEquals(dummyListBarang[0].price, actual[0].price)
        assertEquals(dummyListBarang[0].stock, actual[0].stock)
        assertEquals(dummyListBarang[0].imageUrl, actual[0].imageUrl)
    }
}