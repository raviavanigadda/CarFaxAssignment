package com.example.carfaxassignment.repo

import com.example.carfaxassignment.model.ApiResponse
import com.example.carfaxassignment.model.Vehicle
import com.example.carfaxassignment.network.CarFaxApiService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarFaxRepository @Inject constructor(private val carFaxApiService: CarFaxApiService) {
    var response = ApiResponse()
    var cachedVehicels = emptyList<Vehicle>()

    fun getVehicles(): Observable<ApiResponse> {
        if (response.vehicles.isEmpty()) {
            //Returning vehicles from API
            return carFaxApiService.getVehicles()
                .doOnNext { response = it }
        } else {
            //Returning cached vehicles first, and then API vehicles
            return Observable.just(response)
                .mergeWith(carFaxApiService.getVehicles()).doOnNext { response = it }
        }
    }
}