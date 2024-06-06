package com.example.parcialtp3grupo5ort.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity
import com.example.parcialtp3grupo5ort.database.entities.OfferEntity

@Dao
interface OfferDao {

    @Query("SELECT * FROM offer_table")
    suspend fun getAllOffers(): List<OfferEntity>

    @Query( "SELECT * FROM offer_table WHERE discount = :discount LIMIT 1")
    suspend fun getOfferByDiscount(discount: String): OfferEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOffer(offer: OfferEntity)

    @Update
    suspend fun updateOffer(offer: OfferEntity)

    @Delete
    suspend fun deleteOffer(offer: OfferEntity)
}