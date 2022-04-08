package com.example.carfaxassignment.data.local

import androidx.room.TypeConverter
import com.example.carfaxassignment.data.model.Dealer
import com.example.carfaxassignment.data.model.FirstPhoto
import com.example.carfaxassignment.data.model.Image
import com.example.carfaxassignment.data.model.Vehicle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    /** type converters of Vehicle Table */
    @TypeConverter
    fun fromVehicleList(value: List<Vehicle>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Vehicle>>() {}.type
        return gson.toJson(value, type)
    }


    @TypeConverter
    fun toVehicleList(value: String): List<Vehicle> {
        val gson = Gson()
        val type = object : TypeToken<List<Vehicle>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromDealer(value: Dealer?): String? {
        val gson = Gson()
        val type = object : TypeToken<Dealer?>() {}.type
        return gson.toJson(value, type)
    }


    @TypeConverter
    fun toDealer(value: String?): Dealer? {
        val gson = Gson()
        val type = object : TypeToken<Dealer?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromFirstPhoto(value: FirstPhoto?): String? {
        val gson = Gson()
        val type = object : TypeToken<FirstPhoto?>() {}.type
        return gson.toJson(value, type)
    }


    @TypeConverter
    fun toFirstPhoto(value: String?): FirstPhoto? {
        val gson = Gson()
        val type = object : TypeToken<FirstPhoto?>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromImage(value: Image?): String? {
        val gson = Gson()
        val type = object : TypeToken<Image?>() {}.type
        return gson.toJson(value, type)
    }


    @TypeConverter
    fun toImage(value: String?): Image? {
        val gson = Gson()
        val type = object : TypeToken<Image?>() {}.type
        return gson.fromJson(value, type)
    }

}