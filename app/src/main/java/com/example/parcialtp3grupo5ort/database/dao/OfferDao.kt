package com.example.parcialtp3grupo5ort.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.parcialtp3grupo5ort.database.DestinationEntity
import com.example.parcialtp3grupo5ort.database.OfferEntity

@Dao
interface OfferDao {

    @Query("SELECT * FROM offer_table")
    suspend fun getAllOffers(): List<OfferEntity>

    @Query("SELECT * FROM destination_table WHERE name = :name LIMIT 1")
    suspend fun getOfferByName(name: String): OfferEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(offers: List<OfferEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Update
    suspend fun updateOffer(offer: OfferEntity)

    @Query("DELETE FROM offer_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteOffer(offer: OfferEntity)
}

