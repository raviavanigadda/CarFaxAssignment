package com.example.carfaxassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dealer(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("city")
    val city: String,
):Parcelable