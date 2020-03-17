package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ParametersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameters)
    }

    fun goBack(view: View) {
        val intent = Intent(applicationContext, StationsActivity::class.java)
        startActivity(intent)
        finish()



    }
    override fun onBackPressed() {
        val intent = Intent(applicationContext, StationsActivity::class.java)
        startActivity(intent)
        finish()
    }




}
