package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.remote.WeatherApi
import com.example.weatherapp.view.*
import com.example.weatherapp.viewmodel.MyViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var zipcode = ""
var units = ""
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {//end MainActivity

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)
//        HeaderManager()

        //fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TodayFragment())
            .commit()

        //auto-open settings if there is no saved zipcode
        if(zipcode.isEmpty()){
            var dialog = GetSettingsFragment()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "")


        }
        //button
        binding.btnSettings.setOnClickListener{
            //open settings fragment
            var dialog = GetSettingsFragment()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "")
            while(dialog.isVisible){
                Thread.sleep(500)
                Log.d(TAG, "initViews: while loop is working")
            }

        }//end onClickListener

            //test button to show settings data
        binding.btnTestData.setOnClickListener{
            showData()
            getData(zipcode, units,"51faa06e6dee65d70fc78d57d0a2004a")
        }
    }//end initViews

    fun showData(){
        Toast.makeText(this, "zipcode = $zipcode", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "units = $units", Toast.LENGTH_SHORT).show()
    }

    fun setData(){
        zipcode = MyViewModel().getZip()
        units = MyViewModel().getUnits()
    }

    fun bindResults(weatherData: WeatherData?) {
        binding.tvCurrentTemp.text = weatherData?.main?.temp.toString() + getUnit(units)
        binding.tvLocation.text = weatherData?.name.toString() + ", " + weatherData?.sys?.country.toString()
        binding.tvCondition.text = weatherData?.weather?.get(0)?.description.toString()
    }

    private fun getUnit(units: String): String {
        return when(units){
            "imperial" -> "°F"
            "metric" -> "°C"
            "kelvin" -> "°K"
            else -> "°"
        }
    }

        fun changeBackground(currentTemp: Double, units: String) {
        //valid temp scales: "f" = fahrenheit / "c" = celsius / "k" = kelvin
        if ((currentTemp < 60.00 && units == "imperial")
            ||(currentTemp < 15.55 && units == "metric")
            ||(currentTemp < 288.706 && units == "kelvin")){
            //display cool temp
            binding.headerContainer.setBackgroundResource(R.color.cold)
        }
        else{
//            display warm temp
            binding.headerContainer.setBackgroundResource(R.color.warm)
        }
    }
    fun getData(zip: String, units: String, app_id: String) {
        WeatherApi.initRetrofit().getWeather(zip, units, app_id)
            .enqueue(object : Callback<WeatherData> {
                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    Log.d(TAG, "onFailure: fail to get data")
                }
                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                    if (response.isSuccessful) {
                        val weatherData = response.body()
                        bindResults(weatherData)
                        changeBackground(weatherData?.main?.temp ?: 0.00, units)
                    }
                }
            })
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "test: onResume: on resume triggered")
        getData(zipcode, units,"51faa06e6dee65d70fc78d57d0a2004a")
    }
}

