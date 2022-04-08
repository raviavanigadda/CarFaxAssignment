package com.example.carfaxassignment.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(

    @SerializedName("listings")
    val vehicles : List<Vehicle> = emptyList()
)
