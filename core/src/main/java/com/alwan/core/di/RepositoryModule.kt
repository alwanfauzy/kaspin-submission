package com.alwan.core.di

import com.alwan.core.data.repository.BarangRepositoryImpl
import com.alwan.core.domain.repository.BarangRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideBarangRepository(barangRepository: BarangRepositoryImpl): com.alwan.core.domain.repository.BarangRepository
}