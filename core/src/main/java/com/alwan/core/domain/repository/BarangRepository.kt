package com.alwan.core.domain.repository

import com.alwan.core.domain.model.Barang
import kotlinx.coroutines.flow.Flow

interface BarangRepository {
    fun getAllBarang(): Flow<List<Barang>>

    fun getBarangById(id: String): Flow<Barang>
}