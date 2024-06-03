package com.example.parcialtp3grupo5ort.entities

import android.os.Parcel
import android.os.Parcelable

data class Offer (

    val discount: String = "",
    val description: String = "",
    val imageUrl: String = "",


    ) : Parcelable {
        constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
            parcel.readString().toString(),

        )
        override fun toString(): String {
            return "Offer(discount='$discount', description='$description', imageUrl='$imageUrl')"
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(discount)
            parcel.writeString(description)
            parcel.writeString(imageUrl)

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Offer> {
            override fun createFromParcel(parcel: Parcel): Offer {
                return Offer(parcel)
            }

            override fun newArray(size: Int): Array<Offer?> {
                return arrayOfNulls(size)
            }
        }

    }