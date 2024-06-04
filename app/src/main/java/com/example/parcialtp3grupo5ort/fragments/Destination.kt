package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.adapters.TrendDestinationAdapter
import com.example.parcialtp3grupo5ort.entities.Destination

class Destination : Fragment() {

    private lateinit var viewDestination: View
    private lateinit var btnBack: ImageButton
    private lateinit var rvPhotos: RecyclerView
    /*private var photos: MutableList<Photo> = ArrayList()*/

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