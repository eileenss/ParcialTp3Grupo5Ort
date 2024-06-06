package com.example.parcialtp3grupo5ort.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R

class OfferHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view : View = v
    private val btnFav: ImageView = view.findViewById(R.id.btn_fav_offer)

    fun setDiscount(discount : String){

        val txt: TextView = view.findViewById(R.id.discount)
        txt.text = discount
    }
    fun setDescription(description : String){

        val txt: TextView = view.findViewById(R.id.description)
        txt.text = description
    }

    fun setImgCard(imgCard: Int) {
        val imageView: ImageView = view.findViewById(R.id.imageUrl)
        imageView.setImageResource(imgCard)
    }

    fun setFavIcon(isFavorite: Boolean){
        if (isFavorite) {
            btnFav.setImageResource(R.drawable.heart_blue)
        } else {
            btnFav.setImageResource(R.drawable.heart_white_stroke_black)
        }
    }

    fun setFavClickListener(onClick: () -> Unit){
        btnFav.setOnClickListener { onClick() }
    }

    fun getCardLayout(): View{
        return view.findViewById(R.id.card_offer)

    }
}