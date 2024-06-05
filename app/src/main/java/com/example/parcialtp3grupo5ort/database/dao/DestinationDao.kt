package com.example.parcialtp3grupo5ort.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcialtp3grupo5ort.database.DestinationEntity

@Dao
interface DestinationDao {

    @Query("SELECT * FROM destination_table")
    suspend fun getAllDestinations(): List<DestinationEntity>

    @Query("SELECT * FROM destination_table WHERE name = :name")
    suspend fun getDestinationsByName(name: String): List<DestinationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(destinations: List<DestinationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Query("DELETE FROM destination_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteDestination(destination: List<DestinationEntity>)

}