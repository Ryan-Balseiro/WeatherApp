package com.example.weatherapp.view

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.weatherapp.R

class HeaderManager(view: View) {

    //temp: testing background color change
    var testCounter = 0

    val view: View = view
    lateinit var headerContainer: LinearLayout
    lateinit var currentTempView: TextView
    lateinit var location: TextView
    lateinit var condition: TextView

    fun initViews(){
        //header views
        currentTempView = view.findViewById(R.id.tv_current_temp)
        location = view.findViewById(R.id.tv_location)
        condition = view.findViewById(R.id.tv_condition)
        headerContainer = view.findViewById(R.id.header_container)
        val settings: Button = view.findViewById(R.id.btn_settings)
        settings.setOnClickListener{
            //open settings fragment

            //temp: change background color
            ++testCounter
            if(testCounter == 1){
                changeBackground(75, "f")
            }
            else{
                testCounter = 0
                changeBackground(14, "f")
            }

        }
    }
    private fun changeBackground(currentTemp: Int, tempScale: String) {
        //valid temp scales: "f" = fahrenheit / "c" = celsius / "k" = kelvin
        if ((currentTemp < 60 && tempScale == "f")
            ||(currentTemp < 16 && tempScale == "c")
            ||(currentTemp < 289 && tempScale == "k")){
            //display cool temp
//            view.setBackgroundColor()
            headerContainer.setBackgroundResource(R.color.cold)
        }
        else{
//            display warm temp
            headerContainer.setBackgroundResource(R.color.warm)
        }

        val ct = headerContainer.findViewById<TextView>(R.id.tv_current_temp)
        ct.text = currentTemp.toString()
    }
}