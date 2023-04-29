package com.alwan.core.di.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alwan.core.di.local.entity.BarangEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang")
    fun getAllBarang(): Flow<List<BarangEntity>>

    @Query("SELECT * FROM barang WHERE id = :id")
    fun getBarangById(id: String): Flow<BarangEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg barangs: BarangEntity)
}