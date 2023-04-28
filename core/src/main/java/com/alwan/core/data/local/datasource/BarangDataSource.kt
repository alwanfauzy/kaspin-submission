package com.alwan.core.data.local.datasource

import com.alwan.core.data.local.dao.BarangDao
import com.alwan.core.data.local.entity.BarangEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BarangDataSource @Inject constructor(private val barangDao: BarangDao) {
    fun getAllBarang(): Flow<List<BarangEntity>> = barangDao.getAllBarang()
    fun getBarangById(id: String): Flow<BarangEntity> = barangDao.getBarangById(id)
}