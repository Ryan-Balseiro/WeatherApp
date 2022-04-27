package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.weatherapp.view.HeaderManager
import com.example.weatherapp.view.TodayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){

        val headerContainer: LinearLayout = findViewById(R.id.header_container)
        HeaderManager(headerContainer).initViews()
        //fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,TodayFragment())
            .commit()
    }


}

