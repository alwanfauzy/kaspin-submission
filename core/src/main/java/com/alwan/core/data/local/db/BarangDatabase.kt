package com.alwan.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alwan.core.data.local.dao.BarangDao
import com.alwan.core.data.local.entity.BarangEntity

@Database(entities = [BarangEntity::class], version = 1, exportSchema = false)
abstract class BarangDatabase : RoomDatabase() {
    abstract fun barangDao(): BarangDao
}