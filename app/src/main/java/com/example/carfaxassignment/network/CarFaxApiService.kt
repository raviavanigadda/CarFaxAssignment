package com.example.carfaxassignment.network

import com.example.carfaxassignment.data.model.ApiResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface CarFaxApiService {

    companion object{
        val BASE_URL = "https://carfax-for-consumers.firebaseio.com"
    }
    @GET("/assignment.json")
    fun getVehicles(): Observable<ApiResponse>

}