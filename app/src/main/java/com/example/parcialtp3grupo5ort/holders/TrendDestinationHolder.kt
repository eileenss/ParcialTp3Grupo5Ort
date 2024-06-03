package com.example.parcialtp3grupo5ort.holders

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R

class TrendDestinationHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_name)
        txt.text = name
    }

    fun setCountry(country: String) {
        val txt: TextView = view.findViewById(R.id.txt_country)
        txt.text = country
    }

    fun setCode(code: String) {
        val txt: TextView = view.findViewById(R.id.txt_code)
        txt.text = code
    }

    fun setImg(img: Int) {
        val imageView: ImageView = view.findViewById(R.id.img_trend_dest)
        imageView.setImageResource(img)
    }

    fun getCardLayout(): View {
        return view.findViewById(R.id.card_trend_dest)
    }
}
