package com.alwan.core.di.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alwan.core.di.local.dao.BarangDao
import com.alwan.core.di.local.entity.BarangEntity

@Database(entities = [BarangEntity::class], version = 1, exportSchema = false)
abstract class BarangDatabase : RoomDatabase() {
    abstract fun barangDao(): BarangDao
}