package com.example.parcialtp3grupo5ort.entities

import android.os.Parcel
import android.os.Parcelable
import com.example.parcialtp3grupo5ort.database.entities.OfferEntity

data class Offer (

    val discount: String = "",
    val description: String = "",
    val imageUrl: Int,
    var isFavorite: Boolean = false

    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(discount)
            parcel.writeString(description)
            parcel.writeInt(imageUrl)
            parcel.writeByte(if (isFavorite) 1 else 0)
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

            fun Offer.toEntity():OfferEntity {
                return OfferEntity(
                    discount = this.discount,
                    isFavorite = isFavorite
                )
            }
        }



    }