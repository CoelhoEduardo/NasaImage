package com.example.nasaimage.data.Network

import com.example.nasaimage.BuildConfig
import com.example.nasaimage.data.factory.GsonFactory
import com.example.nasaimage.data.factory.OkHttpFactory
import com.example.nasaimage.data.factory.RetrofitFactory
import com.example.nasaimage.data.model.ApodData
import com.example.nasaimage.data.model.ApodResponse
import retrofit2.create
import retrofit2.http.GET

interface ApodApi {

    @GET("apod?api_key=${BuildConfig.API_KEY}")
    suspend fun getApod(): ApodData

    @GET("apod?api_key=${BuildConfig.API_KEY}&start_date=2022-12-01")
    suspend fun getPicutres(): ApodResponse

    companion object{
        val instance: ApodApi by lazy {
            RetrofitFactory.build(
                OkHttpFactory.build(),
                GsonFactory.build()
            ).create(ApodApi::class.java)
        }
    }
}
