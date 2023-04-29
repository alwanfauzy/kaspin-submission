package com.alwan.core.di.local.datasource

import com.alwan.core.di.local.dao.BarangDao
import com.alwan.core.di.local.entity.BarangEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BarangLocalDataSource @Inject constructor(private val barangDao: BarangDao) {
    fun getAllBarang(): Flow<List<BarangEntity>> = barangDao.getAllBarang()
    fun getBarangById(id: String): Flow<BarangEntity> = barangDao.getBarangById(id)
}