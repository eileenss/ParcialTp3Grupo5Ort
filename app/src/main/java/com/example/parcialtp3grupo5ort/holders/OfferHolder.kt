package com.example.parcialtp3grupo5ort.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R

class OfferHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view : View

    init {
        this.view = v
    }

    fun setDiscount(discout : String){

        val txt: TextView = view.findViewById(R.id.descuento)
        txt.text = discout
    }
    fun setDescription(description : String){

        val txt: TextView = view.findViewById(R.id.description)
        txt.text = description
    }

    fun setImgCard(imgCard: Int) {
        val imageView: ImageView = view.findViewById(R.id.imageUrl)
        imageView.setImageResource(imgCard)
    }

    fun getCardLayout(): View{
        return view.findViewById(R.id.card_offer)

    }
}