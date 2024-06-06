package com.example.parcialtp3grupo5ort.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.parcialtp3grupo5ort.database.dao.DestinationDao
import com.example.parcialtp3grupo5ort.database.dao.OfferDao
import com.example.parcialtp3grupo5ort.entities.Offer

@Database(entities = [DestinationEntity::class],[OfferEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDestinationDao(): DestinationDao
    abstract fun getOfferDao(): OfferDao
}
