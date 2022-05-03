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
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.model.remote.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "TodayFragment"
class TodayFragment: Fragment() {
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
}