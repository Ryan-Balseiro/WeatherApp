package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.weatherapp.view.GetSettingsFragment
import com.example.weatherapp.view.HeaderManager
import com.example.weatherapp.view.TodayFragment

class MainActivity : AppCompatActivity() {

    var zipcode: String = ""
    var units: String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TodayFragment())
                .commit()
        }
        HeaderManager(headerContainer).showData(zipcode, units)

        //button
        val settings: Button = headerContainer.findViewById(R.id.btn_settings)
        settings.setOnClickListener{
            //open settings fragment
            var dialog = GetSettingsFragment()
            dialog.show(supportFragmentManager, "")

        }//end onClickListener

    }//end initViews

    fun setVariables(zip: String, TempUnits: String){
        zipcode = zip
        units = TempUnits
    }

    override fun onResume() {
        super.onResume()
        initViews()
    }

}//end MainActivity

