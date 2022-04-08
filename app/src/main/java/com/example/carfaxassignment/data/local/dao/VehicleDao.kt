package com.example.carfaxassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carfaxassignment.data.model.Vehicle
import io.reactivex.rxjava3.core.Single

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVehicle(vehicle: Vehicle): Long

    @Query("SELECT * FROM _TABLE_VEHICLES")
    fun getAllVehicles(): Single<List<Vehicle>>
}