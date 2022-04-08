package com.example.carfaxassignment.data.model

data class Result(
    val vehicles: List<Vehicle>,
    val status: String,
    val error: Throwable? = null
)