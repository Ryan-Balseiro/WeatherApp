package com.example.weatherapp.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_URL = "https://openweathermap.org/ "
    const val END_POINT = "forecast5"

    val weatherApi: WeatherApi by lazy {
        initRetrofit()
    }

    private fun initRetrofit(): WeatherApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}