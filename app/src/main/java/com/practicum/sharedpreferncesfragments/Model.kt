package com.practicum.sharedpreferncesfragments

import android.os.Parcel
import android.os.Parcelable


data class Model(
    val name:String,
    val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(name)
        p0.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<Model> {
        override fun createFromParcel(parcel: Parcel): Model {
            return Model(parcel)
        }

        override fun newArray(size: Int): Array<Model?> {
            return arrayOfNulls(size)
        }
    }
}