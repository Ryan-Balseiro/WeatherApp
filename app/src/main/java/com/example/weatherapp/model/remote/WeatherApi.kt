package com.example.weatherapp.model.remote

import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.model.remote.Network.API_KEY
import com.example.weatherapp.model.remote.Network.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //@GET(END_POINT)

    //@GET(END_POINT)

    @GET(END_POINT)
    suspend fun getWeathers(
        @Query("zip") zip_code: String,
        @Query("units") units: String,
        @Query("appid") api_key: String = API_KEY,
    ) : WeatherResponse
}