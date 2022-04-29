package com.example.weatherapp.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.weatherapp.MainActivity

var zipCode = ""
var tempUnits = ""

class MyViewModel: ViewModel() {

    fun storeData(zip: String, units: String){
        zipCode = zip
        tempUnits = units
    }

    fun getZip(): String {
        return zipCode
    }

    fun getUnits(): String{
        return tempUnits
    }
}