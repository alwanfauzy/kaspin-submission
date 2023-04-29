package com.alwan.barangku.di

import com.alwan.core.domain.usecase.BarangInteractor
import com.alwan.core.domain.usecase.BarangUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideBarangUseCase(barangInteractor: com.alwan.core.domain.usecase.BarangInteractor): com.alwan.core.domain.usecase.BarangUseCase
}