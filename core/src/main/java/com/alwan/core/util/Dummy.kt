package com.alwan.core.util

import com.alwan.core.di.local.entity.BarangEntity
import com.alwan.core.domain.model.Barang

object Dummy {
    fun generateBarang() = Barang(
        code = "aaabbbcc1",
        name = "Barang1",
        description = "description1",
        stock = 1,
        price = 1,
        imageUrl = "www.gambar.com",
    )

    fun generateListBarangs() = listOf(
        Barang(
            code = "aaabbbcc1",
            name = "Barang1",
            description = "description1",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        Barang(
            code = "aaabbbcc2",
            name = "Barang2",
            description = "description2",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        Barang(
            code = "aaabbbcc3",
            name = "Barang3",
            description = "description3",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        Barang(
            code = "aaabbbcc4",
            name = "Barang4",
            description = "description4",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        Barang(
            code = "aaabbbcc5",
            name = "Barang5",
            description = "description5",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
    )

    fun generateBarangEntity() = BarangEntity(
        id = "aaabbbcc1",
        name = "Barang1",
        description = "description1",
        stock = 1,
        price = 1,
        imageUrl = "www.gambar.com",
    )

    fun generateListBarangEntities() = listOf(
        BarangEntity(
            id = "aaabbbcc1",
            name = "Barang1",
            description = "description1",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        BarangEntity(
            id = "aaabbbcc2",
            name = "Barang2",
            description = "description2",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        BarangEntity(
            id = "aaabbbcc3",
            name = "Barang3",
            description = "description3",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        BarangEntity(
            id = "aaabbbcc4",
            name = "Barang4",
            description = "description4",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
        BarangEntity(
            id = "aaabbbcc5",
            name = "Barang5",
            description = "description5",
            stock = 1,
            price = 1,
            imageUrl = "www.gambar.com",
        ),
    )
}