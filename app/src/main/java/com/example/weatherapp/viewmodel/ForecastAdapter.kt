package com.example.weatherapp.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.TodayItemLayoutBinding
import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.model.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ForecastAdapter"
class ForecastAdapter: RecyclerView.Adapter<ForecastAdapter.forecastViewHolder>() {

    class forecastViewHolder(binding: TodayItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

    }

    fun getForecastData(zip: String, units: String, app_id: String) {
        WeatherApi.initRetrofit().getForecast(zip, units, app_id)
            .enqueue(object : Callback<ForecastData> {
                override fun onFailure(call: Call<ForecastData>, t: Throwable) {
                    Log.d(TAG, "onFailure: failed to get data")
                }
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<ForecastData>, response: Response<ForecastData>) {
                    if (response.isSuccessful) {
                        val forecastData = response.body()
                        bindResults(forecastData)
                    }
                }
            })
    }

    fun bindResults(forecastData: ForecastData?){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): forecastViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: forecastViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}