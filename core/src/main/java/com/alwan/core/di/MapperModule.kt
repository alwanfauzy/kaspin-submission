package com.alwan.core.di

import com.alwan.core.data.mapper.BarangMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun provideBarangMapper() = BarangMapper()
}