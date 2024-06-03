package com.example.parcialtp3grupo5ort.holders

import android.view.TextureView
import android.view.View
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

        val txt: TextView = view.findViewById(R.id.descripcion_card)
        txt.text = description
    }
//    fun setImage(image : String){
//
//        val txt: TextView = view.findViewById(R.id.master_card)
//        txt.text = image
//    }

    fun getCardLayout(): View{
        return view.findViewById(R.id.card_offer)

    }
}