package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.entities.TrendDestination

class Explore : Fragment() {

    private lateinit var viewExplore: View
    lateinit var rvTrendingDestinations: RecyclerView
    private var destinations: MutableList<TrendDestination> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewExplore = inflater.inflate(R.layout.fragment_explore, container, false)

        rvTrendingDestinations = viewExplore.findViewById(R.id.rv_trending_destinations)

        return viewExplore
    }

    override fun onStart(){
        super.onStart()

        destinations.add(TrendDestination(name = "Boracay", country = "Philippines", code = "5D4N", img = R.drawable.boracay))
        destinations.add(TrendDestination(name = "Baros", country = "Maldivas", code = "7D6N", img = R.drawable.baros))
        destinations.add(TrendDestination(name = "Bali", country = "Indonesia", code = "3D2N", img = R.drawable.bali))
        destinations.add(TrendDestination(name = "Palawan", country = "Philippines", code = "3D2N", img = R.drawable.palawan))


        rvTrendingDestinations.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val trendDestAdapter = TrendDestinationAdapter(destinations)

        rvTrendingDestinations.layoutManager = linearLayoutManager
        rvTrendingDestinations.adapter = trendDestAdapter
    }
}