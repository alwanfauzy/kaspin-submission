package com.alwan.barangku.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alwan.core.domain.usecase.BarangUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val barangUseCase: com.alwan.core.domain.usecase.BarangUseCase) : ViewModel() {
    fun getBarangById(id: String) = barangUseCase.getBarangById(id).asLiveData()
}