package com.android.carfax.di


import com.android.carfax.network.CarFaxApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideCarFaxApiService(retrofit: Retrofit): CarFaxApiService =
        retrofit.create(CarFaxApiService::class.java)

}