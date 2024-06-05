package com.example.parcialtp3grupo5ort.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "destination_table")
data class DestinationEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "price") val price: String?
)
