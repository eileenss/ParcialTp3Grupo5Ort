package com.example.parcialtp3grupo5ort.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferRvAdapter
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.database.AppDatabase
import com.example.parcialtp3grupo5ort.database.dao.DestinationDao
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity
import com.example.parcialtp3grupo5ort.entities.OfferRv
import com.example.parcialtp3grupo5ort.entities.Destination
import kotlinx.coroutines.launch

class Explore : Fragment() {

    private lateinit var viewExplore: View
    private lateinit var rvTrendingDestinations: RecyclerView
    private var destinations: MutableList<Destination> = ArrayList()
    private var offers: MutableList<OfferRv> = ArrayList()
    private lateinit var rvOffers: RecyclerView
    private lateinit var btnFav: ImageButton
    private lateinit var db: AppDatabase
    private lateinit var destinationName: TextView
    private lateinit var destinationPrice: TextView
    private lateinit var destinationDao: DestinationDao

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
        btnFav = viewExplore.findViewById(R.id.btn_fav_offer)
        destinationName = viewExplore.findViewById(R.id.txt_paris)
        destinationPrice = viewExplore.findViewById(R.id.txt_price)

        db = AppDatabase.getAppDataBase(requireContext())!!
        destinationDao = db.getDestinationDao()

        val destinationNameText = destinationName.text.toString()

        lifecycleScope.launch {
            val destination = destinationDao.getDestinationsByName(destinationNameText)
            if (destination?.isFavorite == true) {
                btnFav.setImageResource(R.drawable.heart_white) // Marked as favorite
            } else {
                btnFav.setImageResource(R.drawable.heart_white_stroke) // Not marked as favorite
            }
        }

        btnFav.setOnClickListener {
            lifecycleScope.launch {
                val destination = destinationDao.getDestinationsByName(destinationNameText)
                if (destination == null) {
                    // Insert new favorite destination
                    val newDestination = DestinationEntity(name = destinationNameText, price = destinationPrice.text.toString(), isFavorite = true)
                    destinationDao.insertDestination(newDestination)
                    Log.d(TAG, "New destination inserted: $newDestination")
                    btnFav.setImageResource(R.drawable.heart_white) // Set to favorite
                } else {
                    if (destination.isFavorite) {
                        // Remove destination from favorites
                        destinationDao.deleteDestination(destination)
                        Log.d(TAG, "Destination removed: $destination")
                        btnFav.setImageResource(R.drawable.heart_white_stroke) // Set to not favorite
                    } else {
                        // Update existing destination to be favorite
                        val updatedDestination = destination.copy(isFavorite = true)
                        destinationDao.updateDestination(updatedDestination)
                        Log.d(TAG, "Destination updated to favorite: $updatedDestination")
                        btnFav.setImageResource(R.drawable.heart_white) // Set to favorite
                    }
                }
            }
        }

        return viewExplore
    }

    override fun onStart(){
        super.onStart()

        // Recycler Trending Destinations
        listDestinations()
        rvTrendingDestinations.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val trendDestAdapter = TrendDestinationAdapter(destinations)
        rvTrendingDestinations.layoutManager = linearLayoutManager
        rvTrendingDestinations.adapter = trendDestAdapter

        // Recycler Offers
        listOffers()
        rvOffers.setHasFixedSize(true)
        val linearLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val offerAdapter = OfferRvAdapter(offers)
        rvOffers.layoutManager = linearLayoutManager2
        rvOffers.adapter = offerAdapter
    }

    private fun listDestinations(){
        destinations.add(Destination(name = "Boracay", country = "Philippines", code = "5D4N", img = R.drawable.boracay, overview = "", details = "", price = "", photos = arrayListOf()))
        destinations.add(Destination(name = "Baros", country = "Maldivas", code = "7D6N", img = R.drawable.baros, overview = "", details = "", price = "", photos = arrayListOf()))
        destinations.add(Destination(name = "Bali", country = "Indonesia", code = "3D2N", img = R.drawable.bali, overview = "", details = "", price = "", photos = arrayListOf()))
        destinations.add(Destination(name = "Palawan", country = "Philippines", code = "3D2N", img = R.drawable.palawan, overview = "", details = "", price = "", photos = arrayListOf()))
    }

    private fun listOffers(){
        offers.add(OfferRv(imgCard = R.drawable.master_img, title = context?.getString(R.string.txt_master_offer), details = context?.getString(R.string.txt_lim_offer)))
        offers.add(OfferRv(imgCard = R.drawable.visa_img, title = context?.getString(R.string.txt_visa_offer), details = context?.getString(R.string.txt_lim_offer)))
    }
}
