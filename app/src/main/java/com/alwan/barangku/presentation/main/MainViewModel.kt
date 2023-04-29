package com.alwan.barangku.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alwan.core.domain.usecase.BarangUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val barangUseCase: com.alwan.core.domain.usecase.BarangUseCase) : ViewModel() {
    fun getAllBarang() = barangUseCase.getAllBarang().asLiveData()
}