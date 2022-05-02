package com.example.weatherapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.WeatherDaily
//import com.example.weatherapp.viewmodel.WeatherListAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("listWeather")
fun bindWeatherRecyclerView(recyclerView: RecyclerView, data: List<WeatherDaily>?){
//    val adapter = recyclerView.adapter as WeatherListAdapter
//    adapter.updateItems(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){

    imgUrl?.let{
        Picasso.get().load(imgUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_baseline_running_with_errors_24)
            .into(imgView)
    }

}