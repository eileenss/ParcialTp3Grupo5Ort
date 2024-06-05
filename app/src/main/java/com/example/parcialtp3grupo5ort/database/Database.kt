package com.example.parcialtp3grupo5ort.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.parcialtp3grupo5ort.database.dao.DestinationDao

@Database(entities = [DestinationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDestinationDao(): DestinationDao
}