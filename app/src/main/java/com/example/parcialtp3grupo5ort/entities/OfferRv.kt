package com.example.parcialtp3grupo5ort.entities

import android.os.Parcel
import android.os.Parcelable

class OfferRv(imgCard: Int?, title: String?, details: String?) : Parcelable {
    var imgCard: Int
    var title: String
    var details: String

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    init {
        this.imgCard = imgCard!!
        this.title = title!!
        this.details = details!!
    }

    override fun describeContents(): Int {
       return 0
    }

    override fun writeToParcel(offer: Parcel, flags: Int) {
        offer.writeInt(imgCard)
        offer.writeString(title)
        offer.writeString(details)
    }

    companion object CREATOR : Parcelable.Creator<OfferRv> {
        override fun createFromParcel(parcel: Parcel): OfferRv {
            return OfferRv(parcel)
        }

        override fun newArray(size: Int): Array<OfferRv?> {
            return arrayOfNulls(size)
        }
    }
}