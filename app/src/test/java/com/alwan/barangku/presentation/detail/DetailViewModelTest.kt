package com.alwan.barangku.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var barangUseCase: BarangUseCase

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(barangUseCase)
    }

    @Test
    fun `getBarangById() should return Barang with id requested`() = runTest {
        val barangId = "barangId"
        val dummyBarang = Dummy.generateBarang()

        val expected = flowOf(dummyBarang)
        `when`(barangUseCase.getBarangById(barangId)).thenReturn(expected)

        val actual = detailViewModel.getBarangById(barangId).getOrAwaitValue()

        verify(barangUseCase).getBarangById(barangId)
        assertEquals(dummyBarang, actual)
        assertEquals(dummyBarang.code, actual.code)
        assertEquals(dummyBarang.name, actual.name)
        assertEquals(dummyBarang.description, actual.description)
        assertEquals(dummyBarang.price, actual.price)
        assertEquals(dummyBarang.stock, actual.stock)
        assertEquals(dummyBarang.imageUrl, actual.imageUrl)
    }
}