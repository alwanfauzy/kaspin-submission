package com.alwan.core.data.local.datasource

import com.alwan.core.data.local.dao.BarangDao
import com.alwan.core.data.local.entity.BarangEntity
import kotlinx.coroutines.flow.Flow

class BarangDataSource(private val barangDao: BarangDao) {
    fun getAllBarang(): Flow<List<BarangEntity>> = barangDao.getAllBarang()
    fun getBarangById(id: String): Flow<BarangEntity> = barangDao.getBarangById(id)
}