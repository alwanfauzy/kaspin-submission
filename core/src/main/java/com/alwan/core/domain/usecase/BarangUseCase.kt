package com.alwan.core.domain.usecase

import com.alwan.core.domain.model.Barang
import kotlinx.coroutines.flow.Flow

interface BarangUseCase {
    fun getAllBarang(): Flow<List<Barang>>

    fun getBarangById(id: String): Flow<Barang>
}