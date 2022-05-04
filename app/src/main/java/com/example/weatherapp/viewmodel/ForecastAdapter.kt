package com.example.weatherapp.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.TodayItemLayoutBinding
import com.example.weatherapp.model.ForecastData
import com.example.weatherapp.model.remote.WeatherApi
import com.example.weatherapp.units
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ForecastAdapter"
class ForecastAdapter: RecyclerView.Adapter<ForecastAdapter.forecastViewHolder>() {

    class forecastViewHolder(binding: TodayItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        class ItemViewHolder (val view: View):
            RecyclerView.ViewHolder(view){

            private val weatherIcon: ImageView =
                view.findViewById(R.id.iv_weatherIcon)
            private val time: TextView =
                view.findViewById(R.id.tv_time)
            private val temperature: TextView =
                view.findViewById(R.id.tv_temp)

            fun onBind(dataItem: ForecastData, openDetails: (ForecastData) -> Unit){
//                time.text = dataItem.title
//                Picasso.get().load(dataItem.icon).into(weatherIcon)
//                view.setOnClickListener{openDetails(dataItem)}
            }

            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): forecastViewHolder {
//        return ForecastAdapter.ItemViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.movies_item_layout, parent, false
//            )
//        )
        TODO()
    }

    override fun onBindViewHolder(holder: forecastViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        //return ForecastData.size
        TODO()
    }
}