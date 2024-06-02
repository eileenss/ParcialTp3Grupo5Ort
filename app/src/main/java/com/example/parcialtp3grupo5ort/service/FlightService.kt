package com.example.parcialtp3grupo5ort.service

import com.example.parcialtp3grupo5ort.model.FlightResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface FlightService {
    @GET("search")
    fun getFlights(
        @Query("engine") engine: String,
        @Query("api_key") apiKey: String,
        @Query("departure_id") departureId: String,
        @Query("arrival_id") arrivalId: String,
        @Query("outbound_date") outboundDate: String,
        @Query("return_date") returnDate: String
    ): Call<FlightResponse>
}