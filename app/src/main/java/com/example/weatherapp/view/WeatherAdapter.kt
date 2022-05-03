package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.util.Log
import com.example.weatherapp.MainActivity
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.Main
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.weatherapp.view.HeaderManager

private const val TAG = "WeatherAdapter"
class WeatherAdapter {
//    fun getData(zip: String, units: String, app_id: String) {
//        WeatherApi.initRetrofit().getWeather(zip, units, app_id)
//            .enqueue(object : Callback<WeatherData> {
//                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
//                    Log.d(TAG, "onFailure: fail to get data")
//                }
//                @SuppressLint("SetTextI18n")
//                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
//                    if (response.isSuccessful) {
//                        val weatherData = response.body()
//                        MainActivity().bindResults(weatherData)
//                        MainActivity().changeBackground(weatherData?.main?.temp ?: 0.00, units)
//                    }
//                }
//            })
//    }
}