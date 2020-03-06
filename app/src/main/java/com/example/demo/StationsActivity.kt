package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class StationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stations)
    }

    fun goBack(view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
    fun stationInfo(view: View) {
        val intent = Intent(applicationContext, ParametersActivity::class.java)
        startActivity(intent)
    }
    fun stationLocation(view: View) {
        val intent = Intent(applicationContext, StationsMapsActivity::class.java)
        startActivity(intent)
    }


}
