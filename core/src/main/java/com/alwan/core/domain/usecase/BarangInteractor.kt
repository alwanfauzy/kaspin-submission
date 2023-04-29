package com.alwan.core.domain.usecase

import com.alwan.core.domain.model.Barang
import com.alwan.core.domain.repository.BarangRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BarangInteractor @Inject constructor(private val barangRepository: BarangRepository) :
    BarangUseCase {
    override fun getAllBarang(): Flow<List<Barang>> = barangRepository.getAllBarang()

    override fun getBarangById(id: String): Flow<Barang> = barangRepository.getBarangById(id)
}