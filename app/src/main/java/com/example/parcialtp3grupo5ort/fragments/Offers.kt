package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferAdapter
import com.example.parcialtp3grupo5ort.entities.Offer


class Offers : Fragment() {

   lateinit var rootView: View
   lateinit var offer: RecyclerView
   private var offers: MutableList<Offer> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_offers, container, false)


        offer = rootView.findViewById(R.id.list_offert)


        return rootView
    }

    override fun onStart() {
        super.onStart()

        val offer1= Offer("Get 20% discount with your Master credit cards", "Use your mastercard with any transaction and get 20% discount instantly!", "Imagen")
        offers.add(offer1)
        offers.add(Offer("Get 35% discount with your Master credit cards", "Use your mastercard with any transaction and get 25% discount instantly!", "Solo dios sabe"))



        offer.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val offerAdapter = OfferAdapter(offers)

        offer.layoutManager = linearLayoutManager
        offer.adapter = offerAdapter




    }

}