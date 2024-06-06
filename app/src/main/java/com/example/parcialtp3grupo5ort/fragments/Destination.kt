package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.parcialtp3grupo5ort.R
import androidx.lifecycle.lifecycleScope
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDestination = inflater.inflate(R.layout.fragment_destination, container, false)

        destinationName = viewDestination.findViewById(R.id.txt_dest_dest)
        destinationPrice = viewDestination.findViewById(R.id.txt_price_dest)

        btnFav = viewDestination.findViewById(R.id.btn_fav_dest)
        btnBack = viewDestination.findViewById(R.id.btn_back_dest)
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        db = AppDatabase.getAppDataBase(requireContext())!!
        destinationDao = db.getDestinationDao()

        val destinationNameText = destinationName.text.toString()

        lifecycleScope.launch {
            val destination = destinationDao.getDestinationsByName(destinationNameText)
            if (destination?.isFavorite == true) {
                btnFav.setImageResource(R.drawable.heart_blue) // Marked as favorite
            } else {
                btnFav.setImageResource(R.drawable.heart_white_stroke_black) // Not marked as favorite
            }
        }

        btnFav.setOnClickListener {
            lifecycleScope.launch {
                val destination = destinationDao.getDestinationsByName(destinationNameText)
                if (destination == null) {
                    // Insert new favorite destination
                    val newDestination = DestinationEntity(name = destinationNameText, price = destinationPrice.text.toString(), isFavorite = true)
                    destinationDao.insertDestination(newDestination)
                    btnFav.setImageResource(R.drawable.heart_blue) // Set to favorite
                } else {
                    if (destination.isFavorite) {
                        // Remove destination from favorites
                        destinationDao.deleteDestination(destination)
                        btnFav.setImageResource(R.drawable.heart_white_stroke_black) // Set to not favorite
                    } else {
                        // Update existing destination to be favorite
                        val updatedDestination = destination.copy(isFavorite = true)
                        destinationDao.updateDestination(updatedDestination)
                        btnFav.setImageResource(R.drawable.heart_blue) // Set to favorite
                    }
                }
            }
        }
        return viewDestination
    }
}