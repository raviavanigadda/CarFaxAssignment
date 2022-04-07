package com.android.carfax.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.carfax.model.ApiResponse
import com.android.carfax.model.Result
import com.android.carfax.repo.CarFaxRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val carFaxRepository: CarFaxRepository
) : ViewModel() {

    private var _isFavoriteDeck = MutableLiveData<Boolean>()
    val isFavoriteDeck: LiveData<Boolean> = _isFavoriteDeck

    fun getVehicles(): Observable<Result> {
        //Prepare the data for your UI, the vehicels list
        //and maybe some additional data needed as well
//        return carFaxRepository.getVehicles()
//            .map { Result(it, "Vehicles loaded successfully!") }

        return  carFaxRepository.getVehicles()
            .map {
                Log.d("ViewModel","Mapping vehicles to UIData...")
                Result(it, "Top 10 Vehicles")
            }
            .onErrorReturn {
                Log.d("ViewModel","An error occurred $it")
                Result(ApiResponse(), "An error occurred", it)
            }
    }

}