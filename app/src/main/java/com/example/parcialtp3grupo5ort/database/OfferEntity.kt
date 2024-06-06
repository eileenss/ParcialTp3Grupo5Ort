package com.example.parcialtp3grupo5ort.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offer_table")
data class OfferEntity(
    @PrimaryKey
    @ColumnInfo(name = "discount") val discount: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "img_url") val imageUrl: Int,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean
)