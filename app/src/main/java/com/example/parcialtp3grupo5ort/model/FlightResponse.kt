package com.example.parcialtp3grupo5ort.model

data class FlightResponse(
    val best_flights: List<FlightInfo>,
    val other_flights: List<FlightInfo>
)

data class FlightInfo(
    val flights: List<FlightDetail>,
    val total_duration: Int,
    val price: Int
)

data class FlightDetail(
    val departure_airport: Airport,
    val arrival_airport: Airport,
    val airline: String,
    val airline_logo: String,
    val travel_class: String
)

data class Airport(
    val name: String,
    val id: String,
    val time: String
)
