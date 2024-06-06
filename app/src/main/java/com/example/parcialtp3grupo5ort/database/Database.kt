package com.example.parcialtp3grupo5ort.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcialtp3grupo5ort.database.dao.DestinationDao
import com.example.parcialtp3grupo5ort.database.dao.OfferDao
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity
import com.example.parcialtp3grupo5ort.database.entities.OfferEntity

@Database(entities = [DestinationEntity::class, OfferEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDestinationDao(): DestinationDao
    abstract fun getOfferDao(): OfferDao

    companion object {

        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "appDb"
                    ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}

