package com.alwan.core.di.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class BarangEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "stock")
    val stock: Int?,

    @ColumnInfo(name = "price")
    val price: Long?,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?,
)
