package com.alwan.core.data.repository

import com.alwan.core.data.local.datasource.BarangDataSource
import com.alwan.core.data.mapper.BarangMapper
import com.alwan.core.domain.model.Barang
import com.alwan.core.domain.repository.BarangRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BarangRepositoryImpl(
    private val barangDataSource: BarangDataSource,
    private val barangMapper: BarangMapper
) : BarangRepository {
    override fun getAllBarang(): Flow<List<Barang>> = barangDataSource.getAllBarang().map {
        barangMapper.mapEntitiesToDomains(it)
    }

    override fun getBarangById(id: String): Flow<Barang> = barangDataSource.getBarangById(id).map {
        barangMapper.mapEntityToDomain(it)
    }
}