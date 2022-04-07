package com.android.carfax.network

import com.android.carfax.model.ApiResponse
import com.android.carfax.model.Vehicle
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CarFaxApiService {

    companion object{
        val BASE_URL = "https://carfax-for-consumers.firebaseio.com"
    }
    @GET("/assignment.json")
    fun getVehicles(): Observable<ApiResponse>

}