package com.android.carfax.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FirstPhoto(
    @SerializedName("large")
    val large: String
): Parcelable