package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferRvAdapter
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.entities.OfferRv
import com.example.parcialtp3grupo5ort.entities.TrendDestination

class Explore : Fragment() {

    private lateinit var viewExplore: View
    lateinit var rvTrendingDestinations: RecyclerView
    private var destinations: MutableList<TrendDestination> = ArrayList()
    private var offers: MutableList<OfferRv> = ArrayList()
    lateinit var rvOffers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewExplore = inflater.inflate(R.layout.fragment_explore, container, false)

        rvTrendingDestinations = viewExplore.findViewById(R.id.rv_trending_destinations)

        rvOffers = viewExplore.findViewById(R.id.rv_offers_explore)

        return viewExplore
    }

    override fun onStart(){
        super.onStart()

        //Recycler Trending Destinations
        listDestinations()
        rvTrendingDestinations.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val trendDestAdapter = TrendDestinationAdapter(destinations)
        rvTrendingDestinations.layoutManager = linearLayoutManager
        rvTrendingDestinations.adapter = trendDestAdapter

        //Recycler Offers
        listOffers()
        rvOffers.setHasFixedSize(true)
        val linearLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offerAdapter = OfferRvAdapter(offers)
        rvOffers.layoutManager = linearLayoutManager2
        rvOffers.adapter = offerAdapter
    }

    private fun listDestinations(){
        destinations.add(TrendDestination(name = "Boracay", country = "Philippines", code = "5D4N", img = R.drawable.boracay))
        destinations.add(TrendDestination(name = "Baros", country = "Maldivas", code = "7D6N", img = R.drawable.baros))
        destinations.add(TrendDestination(name = "Bali", country = "Indonesia", code = "3D2N", img = R.drawable.bali))
        destinations.add(TrendDestination(name = "Palawan", country = "Philippines", code = "3D2N", img = R.drawable.palawan))
    }

    private fun listOffers(){
        offers.add(OfferRv(imgCard = R.drawable.master_img, title = context?.getString(R.string.txt_master_offer), details = context?.getString(R.string.txt_lim_offer)))
        offers.add(OfferRv(imgCard = R.drawable.visa_img, title = context?.getString(R.string.txt_visa_offer), details = context?.getString(R.string.txt_lim_offer)))
    }
}