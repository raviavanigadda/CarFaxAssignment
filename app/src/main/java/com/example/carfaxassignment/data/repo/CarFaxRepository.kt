package com.example.carfaxassignment.data.repo

import android.util.Log
import com.example.carfaxassignment.data.local.dao.VehicleDao
import com.example.carfaxassignment.data.model.Vehicle
import com.example.carfaxassignment.network.CarFaxApiService
import com.example.carfaxassignment.util.Utils
import javax.inject.Inject
import javax.inject.Singleton
import io.reactivex.rxjava3.core.Observable

@Singleton
class CarFaxRepository @Inject constructor(
    private val carFaxApiService: CarFaxApiService,
    private val vehicleDao: VehicleDao,
    private val utils: Utils
) {

    fun getVehicles(): Observable<List<Vehicle>>{
        val hasConnection = utils.isNetworkAvailable()
        var observableFromApi: Observable<List<Vehicle>>? = null

        if (hasConnection){
            observableFromApi = getVehiclesFromApi()
        }
        val observableFromDb = getVehiclesFromDB()

        return if (hasConnection) Observable.concatArrayEager(observableFromApi, observableFromDb)
        else observableFromDb
    }

    fun getVehiclesFromApi(): Observable<List<Vehicle>> {
        return carFaxApiService.getVehicles()
            .map{
                it.vehicles
            }
            .doOnNext {
                Log.d("CarFaxRepository API * ", it.size.toString())
                for (item in it) {
                    vehicleDao.insertVehicle(item)
                }
            }

    }

    fun getVehiclesFromDB(): Observable<List<Vehicle>>{
        return vehicleDao.getAllVehicles()
            .toObservable()
            .doOnNext {
                Log.e("CarFaxRepository DB *** ", it.size.toString())
            }
    }


}