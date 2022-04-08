package com.example.carfaxassignment.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.carfaxassignment.data.model.Result
import com.example.carfaxassignment.data.repo.CarFaxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val carFaxRepository: CarFaxRepository
) : ViewModel() {


    fun getVehicles(): Observable<Result> {
        return  carFaxRepository.getVehicles()
            .map {
                Log.d("ViewModel","Mapping vehicles to UIData...")
                Result(it, "Top 10 Vehicles")
            }
            .onErrorReturn {
                Log.d("ViewModel","An error occurred $it")
                Result(listOf(), "An error occurred", it)
            }
    }

}