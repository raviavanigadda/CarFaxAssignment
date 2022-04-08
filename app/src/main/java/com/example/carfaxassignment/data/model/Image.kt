package com.example.carfaxassignment.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @SerializedName("firstPhoto")
    val firstPhoto: FirstPhoto
): Parcelable