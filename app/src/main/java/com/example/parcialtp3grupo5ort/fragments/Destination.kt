package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.parcialtp3grupo5ort.database.AppDatabase
import com.example.parcialtp3grupo5ort.database.dao.DestinationDao
import com.example.parcialtp3grupo5ort.database.entities.DestinationEntity
import kotlinx.coroutines.launch

class Destination : Fragment() {

    private lateinit var viewDestination: View
    private lateinit var btnBack: ImageButton
    private lateinit var btnFav: ImageButton
    private lateinit var destinationName: TextView
    private lateinit var destinationPrice: TextView
    private lateinit var db: AppDatabase
    private lateinit var destinationDao: DestinationDao
    /*private var photos: MutableList<Photo> = ArrayList()*/
    /*private lateinit var rvPhotos: RecyclerView*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDestination = inflater.inflate(R.layout.fragment_destination, container, false)

        btnBack = viewDestination.findViewById(R.id.btn_back_dest)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        btnFav = viewDestination.findViewById(R.id.btn_fav_dest)
        destinationName = viewDestination.findViewById(R.id.txt_dest_dest)
        destinationPrice = viewDestination.findViewById(R.id.txt_price_dest)
        db = AppDatabase.getAppDataBase(requireContext())!!
        destinationDao = db.getDestinationDao()

      /*  db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "database-name"
        ).build()
*/
        val destinationNameText = destinationName.text.toString()
        lifecycleScope.launch {
            val destination = destinationDao.getDestinationsByName(destinationNameText)
            if (destination?.isFavorite == true) {
                btnFav.setImageResource(R.drawable.heart_fav) // Marked as favorite
            } else {
                btnFav.setImageResource(R.drawable.heart) // Not marked as favorite
            }
        }

        btnFav.setOnClickListener {
            lifecycleScope.launch {
                val destination = destinationDao.getDestinationsByName(destinationNameText)
                if (destination == null) {
                    // Insert new favorite destination
                    val newDestination = DestinationEntity(name = destinationNameText, price = destinationPrice.text.toString(), isFavorite = true)
                    destinationDao.insertDestination(newDestination)
                    btnFav.setImageResource(R.drawable.heart_fav) // Set to favorite
                } else {
                    if (destination.isFavorite) {
                        // Remove destination from favorites
                        destinationDao.deleteDestination(destination)
                        btnFav.setImageResource(R.drawable.heart) // Set to not favorite
                    } else {
                        // Update existing destination to be favorite
                        val updatedDestination = destination.copy(isFavorite = true)
                        destinationDao.updateDestination(updatedDestination)
                        btnFav.setImageResource(R.drawable.heart_fav) // Set to favorite
                    }
                }
            }
        }

        /* rvPhotos = viewDestination.findViewById(R.id.rv_photos_dest)*/

        /*listPhotos()
        rvPhotos.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val photosAdapter = PhotosAdapter(photos)
        rvPhotos.layoutManager = linearLayoutManager
        rvPhotos.adapter = photosAdapter*/

        return viewDestination
    }

  /*  fun listPhotos(){
        photos.add(Photo(R.drawable.bali))
        photos.add(Photo(R.drawable.baros))
        photos.add(Photo(R.drawable.boracay))
        photos.add(Photo(R.drawable.palawan))
    }*/
}