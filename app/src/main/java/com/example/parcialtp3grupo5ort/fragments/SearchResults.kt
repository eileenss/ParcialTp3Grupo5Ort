package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapter.FlightAdapter
import com.example.parcialtp3grupo5ort.model.FlightInfo
import com.example.parcialtp3grupo5ort.model.FlightResponse
import com.example.parcialtp3grupo5ort.service.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResults : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private val flights = mutableListOf<FlightInfo>()
    lateinit var iconBack: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iconBack = view.findViewById(R.id.ic_back)
        iconBack.setOnClickListener{
            findNavController().navigateUp()
        }
        recyclerView = view.findViewById(R.id.recVuelos)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        flightAdapter = FlightAdapter(flights)
        recyclerView.adapter = flightAdapter

        loadFlights()
    }

    private fun loadFlights() {
        val service = ActivityServiceApiBuilder.create()

        service.getFlights(
            engine = "google_flights",
            apiKey = "123",
            departureId = "EZE",
            arrivalId = "MIA",
            outboundDate = "2024-05-31",
            returnDate = "2024-06-10"
        ).enqueue(object : Callback<FlightResponse> {
            override fun onResponse(call: Call<FlightResponse>, response: Response<FlightResponse>) {
                if (response.isSuccessful) {
                    val flightResponse = response.body()
                    flightResponse?.let {
                        flights.addAll(it.best_flights)
                        flights.addAll(it.other_flights)
                        flightAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                Log.e("FlightApp", t.stackTraceToString())
            }
        })
    }
}
