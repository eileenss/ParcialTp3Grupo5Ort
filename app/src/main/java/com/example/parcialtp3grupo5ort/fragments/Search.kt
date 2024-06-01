package com.example.parcialtp3grupo5ort.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.parcialtp3grupo5ort.R


class Search : Fragment() {

    lateinit var viewSearch: View
    lateinit var btnSearch: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewSearch = inflater.inflate(R.layout.fragment_search, container, false)
        btnSearch = viewSearch.findViewById(R.id.button_search)
        btnSearch.setOnClickListener {
            val action = SearchDirections.actionSearchToSearchResults()
            viewSearch.findNavController().navigate(action)
        }
        return viewSearch
    }


}