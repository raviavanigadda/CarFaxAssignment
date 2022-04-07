package com.example.carfaxassignment.model

data class Result(
    val response: ApiResponse,
    val status: String,
    val error: Throwable? = null
)