package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//activity only exists to be closed to trigger onResume in MainActivity
class TempActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_layout)
        finish()
    }


}