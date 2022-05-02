package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.remote.WeatherApi
import com.example.weatherapp.units
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "HeaderManager"
class HeaderManager: AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
//
////    init {
////        setContentView(R.layout.activity_main)
////        binding = ActivityMainBinding.inflate(
////                layoutInflater
////                )
////        setContentView(binding.root)
////    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(
//            layoutInflater
//        )
//        setContentView(binding.root)
//    }
//
////    fun getData(zip: String, units: String, app_id: String) {
////        WeatherApi.initRetrofit().getWeather(zip, units, app_id)
////            .enqueue(object : Callback<WeatherData> {
////                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
////                    Log.d(TAG, "onFailure: fail to get data")
////                }
////                @SuppressLint("SetTextI18n")
////                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
////                    if (response.isSuccessful) {
////                        val weatherData = response.body()
////                        bindResults(weatherData)
////                        changeBackground(weatherData?.main?.temp ?: 0.00, units)
////                    }
////                }
////            })
////    }
//    fun changeBackground(currentTemp: Double, units: String) {
//        //val headerContainer: LinearLayout = MainActivity().returnMainView()
//        //valid temp scales: "f" = fahrenheit / "c" = celsius / "k" = kelvin
//        if ((currentTemp < 60.00 && units == "imperial")
//            ||(currentTemp < 15.55 && units == "metric")
//            ||(currentTemp < 288.706 && units == "kelvin")){
//            //display cool temp
//            binding.headerContainer.setBackgroundResource(R.color.cold)
//        }
//        else{
////            display warm temp
//            binding.headerContainer.setBackgroundResource(R.color.warm)
//        }
//    }
//    fun bindResults(weatherData: WeatherData?) {
////        val headerContainer: LinearLayout = MainActivity().returnMainView()
//
//        binding.tvCurrentTemp.text = weatherData?.main?.temp.toString() + getUnit(units)
//        binding.tvLocation.text = weatherData?.name.toString() + ", " + weatherData?.sys?.country.toString()
//        binding.tvCondition.text = weatherData?.weather?.get(0)?.description.toString()
////        headerContainer.findViewById<TextView>(R.id.tv_current_temp).text = weatherData?.main?.temp.toString() + getUnit(units)
////        headerContainer.findViewById<TextView>(R.id.tv_condition).text = weatherData?.weather?.get(0)?.description.toString()
////        headerContainer.findViewById<TextView>(R.id.tv_location).text =
////            weatherData?.name.toString() + ", " + weatherData?.sys?.country.toString()
//    }
//
//    private fun getUnit(units: String): String {
//        return when(units){
//            "imperial" -> "°F"
//            "metric" -> "°C"
//            "kelvin" -> "°K"
//            else -> "°"
//        }
//    }
}