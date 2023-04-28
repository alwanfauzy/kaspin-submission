package com.alwan.core.domain.model

data class Barang(
    val code: String,
    val name: String,
    val description: String,
    val stock: Int,
    val price: Long,
    val imageUrl: String,
)
