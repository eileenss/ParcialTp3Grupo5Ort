package com.example.parcialtp3grupo5ort.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offer_table")
data class OfferEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "discount") val discount: String,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean
)
