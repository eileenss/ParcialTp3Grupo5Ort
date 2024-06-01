package com.example.parcialtp3grupo5ort.entities

import android.os.Parcel
import android.os.Parcelable

class TrendDestination(name: String?, country: String?, code: String?, img: Int?) : Parcelable {
    var name: String
    var country: String
    var code: String
    var img: Int

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    init{
        this.name = name!!
        this.country = country!!
        this.code = code!!
        this.img = img!!
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(country)
        dest.writeString(code)
        dest.writeInt(img)
    }

    companion object CREATOR : Parcelable.Creator<TrendDestination> {
        override fun createFromParcel(parcel: Parcel): TrendDestination {
            return TrendDestination(parcel)
        }

        override fun newArray(size: Int): Array<TrendDestination?> {
            return arrayOfNulls(size)
        }
    }


}