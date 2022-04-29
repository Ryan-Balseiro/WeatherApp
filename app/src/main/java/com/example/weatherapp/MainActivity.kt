package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.view.GetSettingsFragment
import com.example.weatherapp.view.HeaderManager
import com.example.weatherapp.view.TodayFragment
import com.example.weatherapp.viewmodel.MyViewModel

var zipcode = ""
var units = ""

class MainActivity : AppCompatActivity() {

//    var zipcode: String = ""
//    var units: String= ""
//    lateinit var zipcode: String
//    lateinit var units: String
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val headerContainer: LinearLayout = findViewById(R.id.header_container)
        HeaderManager(headerContainer).initViews()
        //fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TodayFragment())
            .commit()

        if(zipcode.isEmpty()){
            var dialog = GetSettingsFragment()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "")
        }
        //HeaderManager(headerContainer).showData(zipcode, units)
//        showData()

        //button
        val settings: Button = headerContainer.findViewById(R.id.btn_settings)
        settings.setOnClickListener{
            //open settings fragment
            var dialog = GetSettingsFragment()
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "")

        }//end onClickListener

            //test button to show settings data
        binding.btnTestData.setOnClickListener{
            showData()
        }

    }//end initViews

    fun showData(){
        Toast.makeText(this, "zipcode = $zipcode", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "units = $units", Toast.LENGTH_SHORT).show()
    }

    fun setData(){
        zipcode = MyViewModel().getZip()
        units = MyViewModel().getUnits()
    }

}//end MainActivity

