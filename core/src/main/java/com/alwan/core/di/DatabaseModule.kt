package com.alwan.core.di

import android.content.Context
import androidx.room.Room
import com.alwan.core.data.local.db.BarangDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BarangDatabase {

        return Room.databaseBuilder(context, BarangDatabase::class.java, "Barang.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideBarangDao(barangDatabase: BarangDatabase) = barangDatabase.barangDao()
}