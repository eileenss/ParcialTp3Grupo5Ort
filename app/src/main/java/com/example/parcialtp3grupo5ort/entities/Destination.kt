package com.example.parcialtp3grupo5ort.entities

import android.os.Parcel
import android.os.Parcelable

class Destination(name: String?, country: String?, code: String?, img: Int?, overview: String?, details: String?, price: String?, photos: ArrayList<Int>?) : Parcelable {
    var name: String
    var country: String
    var code: String
    var img: Int
    var overview: String
    var details: String
    var price: String
    var photos: ArrayList<Int>

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createIntArray()?.toCollection(ArrayList())
    )

    init{
        this.name = name!!
        this.country = country!!
        this.code = code!!
        this.img = img!!
        this.overview = overview!!
        this.details = details!!
        this.price = price!!
        this.photos = photos!!

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(country)
        dest.writeString(code)
        dest.writeInt(img)
        dest.writeString(overview)
        dest.writeString(details)
        dest.writeString(price)
        dest.writeIntArray(photos.toIntArray())
    }

    companion object CREATOR : Parcelable.Creator<Destination> {
        override fun createFromParcel(parcel: Parcel): Destination {
            return Destination(parcel)
        }

        override fun newArray(size: Int): Array<Destination?> {
            return arrayOfNulls(size)
        }
    }


}