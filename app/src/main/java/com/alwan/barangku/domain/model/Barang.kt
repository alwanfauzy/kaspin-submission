package com.alwan.barangku.domain.model

import java.math.BigDecimal

data class Barang(
    val code: String,
    val name: String,
    val description: String,
    val stock: Int,
    val price: Long,
    val imageUrl: String,
)
