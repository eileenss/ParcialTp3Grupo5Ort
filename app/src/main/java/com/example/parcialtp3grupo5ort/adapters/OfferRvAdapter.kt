package com.example.parcialtp3grupo5ort.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.entities.OfferRv
import com.example.parcialtp3grupo5ort.holders.OfferRvHolder

class OfferRvAdapter (
    private val offers: MutableList<OfferRv>
): RecyclerView.Adapter<OfferRvHolder>() {

    override fun getItemCount() = offers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferRvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_card, parent, false)
        return OfferRvHolder(view)
    }

    override fun onBindViewHolder(holder: OfferRvHolder, position: Int) {
        val offer = offers[position]

        holder.setImgCard(offer.imgCard)
        holder.setTittle(offer.title)
        holder.setDetails(offer.details)
    }

}