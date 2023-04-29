package com.alwan.core.data.mapper

import com.alwan.core.di.local.entity.BarangEntity
import com.alwan.core.domain.model.Barang
import com.alwan.core.util.orEmpty
import com.alwan.core.util.orImageUrlPlaceholder
import com.alwan.core.util.orZero
import javax.inject.Inject

class BarangMapper @Inject constructor() {
    fun mapEntitiesToDomains(from: List<BarangEntity>) = from.map {
        mapEntityToDomain(it)
    }

    fun mapEntityToDomain(from: BarangEntity) = com.alwan.core.domain.model.Barang(
        code = from.id,
        name = from.name.orEmpty(),
        description = from.description.orEmpty(),
        stock = from.stock.orZero(),
        price = from.price.orZero(),
        imageUrl = from.imageUrl.orImageUrlPlaceholder(),
    )
}