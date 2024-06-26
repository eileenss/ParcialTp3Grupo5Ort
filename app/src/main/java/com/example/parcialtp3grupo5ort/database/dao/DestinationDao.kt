package com.example.parcialtp3grupo5ort.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity

@Dao
interface DestinationDao {

    @Query("SELECT * FROM destination_table")
    suspend fun getAllDestinations(): List<DestinationEntity>

    @Query("SELECT * FROM destination_table WHERE name = :name LIMIT 1")
    suspend fun getDestinationsByName(name: String): DestinationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(destinations: List<DestinationEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Update
    suspend fun updateDestination(destination: DestinationEntity)

    @Query("DELETE FROM destination_table")
    suspend fun deleteAllDestination()

    @Delete
    suspend fun deleteDestination(destination: DestinationEntity)
}
