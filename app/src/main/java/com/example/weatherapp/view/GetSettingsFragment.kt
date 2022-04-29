package com.example.weatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R

class GetSettingsFragment: DialogFragment() {

    lateinit var zip: String
    lateinit var tempUnits: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_settings_layout,
            container,
            false
        )

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
//        view.findViewById<CardView>(R.id.cardView).setOnClickListener{
//            //do nothing. this prevents user from being able to click off the dialog
//        }
        view.findViewById<Button>(R.id.btn_submit).setOnClickListener {
            zip = view.findViewById<EditText>(R.id.et_zip).text.toString()
            when (true) {
                view.findViewById<RadioButton>(R.id.rb_fahrenheit).isChecked -> tempUnits = "f"
                view.findViewById<RadioButton>(R.id.rb_celsius).isChecked -> tempUnits = "c"
                view.findViewById<RadioButton>(R.id.rb_kelvin).isChecked -> tempUnits = "k"
                else -> {
                    tempUnits = "f"
                }
            }
            if (zip.isNotEmpty() && zip.length == 5) {
                MainActivity().setVariables(zip, tempUnits)
                dismiss()
            }
            else {
                Toast.makeText(context, "Please enter a valid zip code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

