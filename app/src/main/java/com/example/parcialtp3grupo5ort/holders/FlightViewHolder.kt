package com.example.parcialtp3grupo5ort.holders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.fragments.SearchResultsDirections
import com.example.parcialtp3grupo5ort.model.FlightInfo
import com.squareup.picasso.Picasso

class FlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val airlineLogo: ImageView = view.findViewById(R.id.airlineLogo)
    private val airlineName: TextView = view.findViewById(R.id.airlineName)
    private val departureAirportName: TextView = view.findViewById(R.id.departureAirportName)
    private val arrivalAirportName: TextView = view.findViewById(R.id.arrivalAirportName)
    private val travelClassText: TextView = view.findViewById(R.id.travelClassText)
    private val flightPrice: TextView = view.findViewById(R.id.flightPrice)
    private val tiempoVuelo: TextView = view.findViewById(R.id.tiempoVuelo)
    private val btnDetails: Button = view.findViewById(R.id.btn_details)

    fun bind(flight: FlightInfo) {
        val firstFlight = flight.flights.first()
        val lastFlight = flight.flights.last()

       Picasso.get().load(firstFlight.airline_logo).into(airlineLogo)
        airlineName.text = firstFlight.airline
        departureAirportName.text = firstFlight.departure_airport.name
        arrivalAirportName.text = lastFlight.arrival_airport.name
        travelClassText.text = firstFlight.travel_class
        flightPrice.text = "$${flight.price}"
        tiempoVuelo.text = formatDuration(flight.total_duration)

        btnDetails.setOnClickListener {
            val action = SearchResultsDirections.actionSearchResultsToDestination()
            btnDetails.findNavController().navigate(action)
        }
    }

    private fun formatDuration(duration: Int): String {
        val hours = duration / 60
        val minutes = duration % 60
        return "$hours h $minutes m"
    }
}
