package com.example.weatherapp.model.remote

import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.model.WeatherData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(END_POINT_WEATHER)
    fun getWeather(
        @Query("zip") zip_code: String,
        @Query("units") units: String,
        @Query("appid") api_key: String = API_KEY,
    ) : Call<WeatherData>

    @GET(END_POINT_FORECAST)
    fun getForecast(
        @Query("zip") zip_code: String,
        @Query("units") units: String,
        @Query("appid") api_key: String = API_KEY,
    ) : Call<ForecastData>

    companion object{
        const val BASE_URL = "https://api.openweathermap.org/"
        const val END_POINT_FORECAST = "data/2.5/forecast"
        const val END_POINT_WEATHER = "data/2.5/weather"
        const val API_KEY = "51faa06e6dee65d70fc78d57d0a2004a"

        fun initRetrofit(): WeatherApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
        }
    }
}

