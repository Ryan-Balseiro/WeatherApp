package com.example.weatherapp.toberemoved

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.weatherapp.R

class CompoundHeader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    var currentTempInt = 0

    init{
        val view = LayoutInflater.from(context).inflate(
            R.layout.header_layout,
            this
        )
        setupUI(view)
        updateDisplay(view)
    }

    private fun setupUI(view: View){
        //val currentTemp = view.findViewById<TextView>(R.id.tv_current_temp)
        view.findViewById<Button>(R.id.btn_settings).setOnClickListener {
            //updateDisplay(view)
            //open settings fragment
        }
    }

    private fun updateDisplay(view: View) {
        //view.findViewById<TextView>(R.id.edit_text).text = counter.toString()
        changeBackground(view)
    }

    private fun changeBackground(view: View) {
        val currentTemp = view.findViewById<TextView>(R.id.tv_current_temp)
        //var body = view.background //(R.id.cl_body)
        currentTempInt = currentTemp.text.toString().toInt()
        if (currentTempInt < 60){
            //display cool temp
            //view.background =
        }
        else{
//            display warm temp
        }
    }
}