package com.example.carfaxassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.carfaxassignment.data.local.dao.VehicleDao
import com.example.carfaxassignment.di.SingletonHolder
import com.example.carfaxassignment.data.model.Vehicle
import com.example.carfaxassignment.util.CAR_FAX_DATABASE

@Database(entities = [Vehicle::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class CarFaxDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao

    companion object : SingletonHolder<CarFaxDatabase, Context>({
        Room.databaseBuilder(
            it.applicationContext, CarFaxDatabase::class.java,
            CAR_FAX_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    })

}