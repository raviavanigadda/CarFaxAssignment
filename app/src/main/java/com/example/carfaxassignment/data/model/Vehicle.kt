package com.example.carfaxassignment.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.carfaxassignment.util.TABLE_VEHICLES
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_VEHICLES)
data class Vehicle(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("make")
    val make: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("trim")
    val trim: String,
    @SerializedName("dealer")
    val dealer: Dealer,
    @SerializedName("vin")
    val vin: String,
    @SerializedName("mileage")
    val milage: Int,
    @SerializedName("currentPrice")
    val currentPrice: Float,
    @SerializedName("exteriorColor")
    val exteriorColor: String,
    @SerializedName("interiorColor")
    val interiorColor: String,
    @SerializedName("engine")
    val engine: String,
    @SerializedName("drivetype")
    val driveType: String,
    @SerializedName("transmission")
    val transmission: String,
    @SerializedName("bodytype")
    val bodyType: String,
    @SerializedName("images")
    val images: Image,
    @SerializedName("fuel")
    val fuel: String,
):Parcelable