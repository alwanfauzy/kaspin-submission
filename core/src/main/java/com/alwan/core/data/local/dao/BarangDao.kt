package com.alwan.core.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.alwan.core.data.local.entity.BarangEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang")
    fun getAllBarang(): Flow<List<BarangEntity>>

    @Query("SELECT * FROM barang WHERE id = :id")
    fun getBarangById(id: String): Flow<BarangEntity>
}