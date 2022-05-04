package com.example.weatherapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.TodayFragmentLayoutBinding
import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "TodayFragment"
class TodayFragment: Fragment(R.layout.today_fragment_layout) {
    //private lateinit var weatherList: RecyclerView

    private lateinit var binding: TodayFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
//        val view = inflater.inflate(
//            R.layout.today_fragment_layout,
//            container,
//            false
//        )
        binding = TodayFragmentLayoutBinding.inflate(
            layoutInflater
        )

        initViews()
        return binding.root
    }

    private fun initViews() {
//        setContentView(binding.root)
        binding.rvItemList.layoutManager = GridLayoutManager(context, 4)
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
        //binding.tvCurrentTemp.text = weatherData?.main?.temp.toString() + getUnit(units)

    }
}