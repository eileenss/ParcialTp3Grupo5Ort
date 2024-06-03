package com.example.parcialtp3grupo5ort.holders

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo5ort.R

class OfferRvHolder(v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setImgCard(imgCard: Int) {
        val imageView: ImageView = view.findViewById(R.id.credit_card_img)
        imageView.setImageResource(imgCard)
    }

    fun setTittle(tittle: String) {
        val txt: TextView = view.findViewById(R.id.txt_offer)

        val spannable = SpannableString(tittle)
        val discountIndex = tittle.indexOf("discount", ignoreCase = true)
        if (discountIndex != -1) {
            spannable.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                discountIndex + "discount".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        txt.text = spannable
    }

    fun setDetails(details: String) {
        val txt: TextView = view.findViewById(R.id.txt_offer_time)
        txt.text = details
    }

    fun getCardLayout(): View{
        return view.findViewById(R.id.card_view_offer)
    }
}