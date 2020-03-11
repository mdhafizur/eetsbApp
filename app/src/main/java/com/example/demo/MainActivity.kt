package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun changeActivity(view: View){
        val intent = Intent(applicationContext, StationsActivity::class.java)
        startActivity(intent)
    }





    }





