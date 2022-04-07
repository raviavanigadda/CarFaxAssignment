package com.example.carfaxassignment.model

import com.example.carfaxassignment.model.Vehicle
import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @SerializedName("listings")
    val vehicles : List<Vehicle> = emptyList()
)
