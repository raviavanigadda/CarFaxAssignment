package com.android.carfax.model

import com.google.gson.annotations.SerializedName

data class Result(
    val response: ApiResponse,
    val status: String,
    val error: Throwable? = null
)