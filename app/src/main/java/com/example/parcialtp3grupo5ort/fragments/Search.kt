package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferRvAdapter
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.entities.OfferRv


class Search : Fragment() {

    lateinit var viewSearch: View
    lateinit var btnSearch: Button
    private var offers: MutableList<OfferRv> = ArrayList()
    lateinit var rvOffers: RecyclerView
    lateinit var iconBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewSearch = inflater.inflate(R.layout.fragment_search, container, false)
        iconBack = viewSearch.findViewById(R.id.ic_back)
        btnSearch = viewSearch.findViewById(R.id.button_search)
        btnSearch.setOnClickListener {
            val action = SearchDirections.actionSearchToSearchResults()
            viewSearch.findNavController().navigate(action)
        }

        iconBack.setOnClickListener{
            findNavController().navigateUp()
        }
        rvOffers = viewSearch.findViewById(R.id.rv_offers_explore)
        return viewSearch
    }

    override fun onStart(){
        super.onStart()


        //Recycler Offers
        listOffers()
        rvOffers.setHasFixedSize(true)
        val linearLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offerAdapter = OfferRvAdapter(offers)
        rvOffers.layoutManager = linearLayoutManager2
        rvOffers.adapter = offerAdapter
    }

    private fun listOffers(){
        offers.add(OfferRv(imgCard = R.drawable.master_img, title = context?.getString(R.string.txt_master_offer), details = context?.getString(R.string.txt_lim_offer)))
        offers.add(OfferRv(imgCard = R.drawable.visa_img, title = context?.getString(R.string.txt_visa_offer), details = context?.getString(R.string.txt_lim_offer)))
    }


}