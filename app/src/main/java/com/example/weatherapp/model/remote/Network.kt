package com.example.weatherapp.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_URL = "api.openweathermap.org/"
    const val END_POINT = "data/2.5/forecast"
    const val API_KEY = "51faa06e6dee65d70fc78d57d0a2004a"
    //need to pass zip, appid, and units
    //appid = 51faa06e6dee65d70fc78d57d0a2004a

//    val weatherApi: WeatherApi by lazy {
//        initRetrofit()
//    }

//    private fun initRetrofit(): WeatherApi{
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(WeatherApi::class.java)
//    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    object WeatherApiObj {
        val retrofitService: WeatherApi by lazy {
            retrofit.create(WeatherApi::class.java)
        }
    }
}