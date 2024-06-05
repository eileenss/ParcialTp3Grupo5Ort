package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.OfferRvAdapter
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.database.AppDatabase
import com.example.parcialtp3grupo5ort.database.DestinationEntity
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
    private val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Perform schema changes like adding a new column
            database.execSQL("ALTER TABLE destination_table ADD COLUMN is_favorite INTEGER NOT NULL DEFAULT 0")
        }
    }

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
        btnFav = viewExplore.findViewById(R.id.btn_fav_explore)
        destinationName = viewExplore.findViewById(R.id.txt_paris)
        destinationPrice = viewExplore.findViewById(R.id.txt_price)

        db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "database-name"
        )
            .addMigrations(MIGRATION_1_2)
            .build()

        val destinationNameText = destinationName.text.toString()

        lifecycleScope.launch {
            val destination = db.getDestinationDao().getDestinationsByName(destinationNameText)
            if (destination?.isFavorite == true) {
                btnFav.setImageResource(R.drawable.heart)
            } else {
                btnFav.setImageResource(R.drawable.heart_fav)
            }
        }

        btnFav.setOnClickListener {
            lifecycleScope.launch {
                val destination = db.getDestinationDao().getDestinationsByName(destinationNameText)
                if (destination == null) {
                    val newDestination = DestinationEntity(name = destinationNameText, price = destinationPrice.text.toString(), isFavorite = true)
                    db.getDestinationDao().insertDestination(newDestination)
                    btnFav.setImageResource(R.drawable.heart)
                } else {
                    val updatedDestination = destination.copy(isFavorite = !destination.isFavorite)
                    db.getDestinationDao().updateDestination(updatedDestination)
                    if (updatedDestination.isFavorite) {
                        btnFav.setImageResource(R.drawable.heart)
                    } else {
                        btnFav.setImageResource(R.drawable.heart_fav)
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
