package com.example.parcialtp3grupo5ort.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferAdapter
import com.example.parcialtp3grupo5ort.database.AppDatabase
import com.example.parcialtp3grupo5ort.database.dao.OfferDao
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity
import com.example.parcialtp3grupo5ort.database.entities.OfferEntity
import com.example.parcialtp3grupo5ort.entities.Offer
import com.example.parcialtp3grupo5ort.entities.Offer.CREATOR.toEntity
import kotlinx.coroutines.launch


class Offers : Fragment() {

    lateinit var viewOffer: View
    lateinit var offerRv: RecyclerView
    private var offers: MutableList<Offer> = ArrayList()
    lateinit var iconBack: ImageView
    lateinit var db: AppDatabase
    lateinit var offerDao: OfferDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewOffer = inflater.inflate(R.layout.fragment_offers, container, false)

        offerRv = viewOffer.findViewById(R.id.list_offert)

        iconBack = viewOffer.findViewById(R.id.back_offer)
        iconBack.setOnClickListener {
            findNavController().navigateUp()
        }

        db = AppDatabase.getAppDataBase(requireContext())!!
        offerDao = db.getOfferDao()

        return viewOffer
    }

    override fun onStart() {
        super.onStart()

        loadOffers()
        offerRv.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        val offerAdapter = OfferAdapter(offers) { offer ->
            lifecycleScope.launch {
                onOfferClick(offer)
            }
        }
        offerRv.layoutManager = linearLayoutManager
        offerRv.adapter = offerAdapter

    }

    private fun loadOffers() {
        offers.add(
            Offer(
                discount = R.string.txt_master_offer.toString(),
                description = R.string.txt_master_description.toString(),
                imageUrl = R.drawable.master_img,
                isFavorite = false
            )
        )
        offers.add(
            Offer(
                discount = R.string.txt_visa_offer.toString(),
                description = R.string.txt_visa_description.toString(),
                imageUrl = R.drawable.visa_img,
                isFavorite = false
            )
        )
    }

    private suspend fun onOfferClick(offer: Offer) {
        val existingOffer = offerDao.getOfferByDiscount(offer.discount)
        if (existingOffer == null) {
           val newOffer = OfferEntity(discount = offer.discount, isFavorite = true)
            offerDao.insertOffer(newOffer)
            Log.d(ContentValues.TAG, "New offer inserted: $newOffer")
        } else{
            if (existingOffer.isFavorite) {
                offerDao.deleteOffer(existingOffer)
                Log.d(ContentValues.TAG, "Offer removed: $existingOffer")
            } else {
                val updateOffer = existingOffer.copy(isFavorite = true)
                offerDao.updateOffer(updateOffer)
                Log.d(ContentValues.TAG, "Offer updated to favorite: $updateOffer")
            }
        }
    }
}

