package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class TodayFragment: Fragment() {
    private lateinit var weatherList: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.today_fragment_layout,
            container,
            false
        )
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        weatherList = view.findViewById(R.id.rv_item_list)
        weatherList.layoutManager = GridLayoutManager(context, 4)
    }
}