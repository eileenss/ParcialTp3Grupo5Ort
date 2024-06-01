package com.example.parcialtp3grupo5ort.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.entities.TrendDestination
import com.example.parcialtp3grupo5ort.holders.TrendDestinationHolder

class TrendDestinationAdapter(
    private val trendingDestinations: MutableList<TrendDestination>
) : RecyclerView.Adapter<TrendDestinationHolder>() {

    override fun getItemCount() = trendingDestinations.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendDestinationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trending_destination, parent, false)
        return (TrendDestinationHolder(view))
    }

    override fun onBindViewHolder(holder: TrendDestinationHolder, position: Int) {
        val trendingDestination = trendingDestinations[position]

        holder.setName(trendingDestination.name)
        holder.setCountry(trendingDestination.country)
        holder.setCode(trendingDestination.code)
        holder.setImg(trendingDestination.img)
    }





}