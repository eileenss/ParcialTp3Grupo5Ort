package com.example.parcialtp3grupo5ort.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R
import com.example.parcialtp3grupo5ort.entities.Offer
import com.example.parcialtp3grupo5ort.holders.OfferHolder




class OfferAdapter(
private val offers: MutableList<Offer>

) : RecyclerView.Adapter<OfferHolder>() {

    override fun getItemCount() = offers.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OfferHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_offers, parent, false)
        return (OfferHolder(view))
    }

    override fun onBindViewHolder(
        holder: OfferHolder,
        position: Int
    ) {

        val offer = offers[position]

        holder.setDiscount(offer.discount)
        holder.setDescription(offer.description)
        //holder.setAvatar(contact.avatar)

        /*holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(contact)
        }*/
    }

}
