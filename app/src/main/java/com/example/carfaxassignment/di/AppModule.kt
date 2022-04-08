package com.example.carfaxassignment.di

import android.content.Context
import androidx.room.Room
import com.example.carfaxassignment.data.local.CarFaxDatabase
import com.example.carfaxassignment.data.local.dao.VehicleDao
import com.example.carfaxassignment.network.CarFaxApiService
import com.example.carfaxassignment.util.CAR_FAX_DATABASE
import com.example.carfaxassignment.util.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CarFaxApiService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCarFaxDatabase(@ApplicationContext context: Context): CarFaxDatabase =
        Room.databaseBuilder(
            context,
            CarFaxDatabase::class.java, CAR_FAX_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCarFaxApiService(retrofit: Retrofit): CarFaxApiService =
        retrofit.create(CarFaxApiService::class.java)

    @Provides
    @Singleton
    fun provideVehicleDao(
        database: CarFaxDatabase
    ): VehicleDao = database.vehicleDao()

    @Provides
    @Singleton
    fun provideUtils(@ApplicationContext context: Context): Utils = Utils(context)

}