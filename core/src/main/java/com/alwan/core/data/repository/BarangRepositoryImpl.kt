package com.alwan.core.data.repository

import com.alwan.core.di.local.datasource.BarangLocalDataSource
import com.alwan.core.data.mapper.BarangMapper
import com.alwan.core.domain.model.Barang
import com.alwan.core.domain.repository.BarangRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BarangRepositoryImpl @Inject constructor(
    private val barangLocalDataSource: BarangLocalDataSource,
    private val barangMapper: BarangMapper
) : com.alwan.core.domain.repository.BarangRepository {
    override fun getAllBarang(): Flow<List<com.alwan.core.domain.model.Barang>> = barangLocalDataSource.getAllBarang().map {
        barangMapper.mapEntitiesToDomains(it)
    }

    override fun getBarangById(id: String): Flow<com.alwan.core.domain.model.Barang> = barangLocalDataSource.getBarangById(id).map {
        barangMapper.mapEntityToDomain(it)
    }
}