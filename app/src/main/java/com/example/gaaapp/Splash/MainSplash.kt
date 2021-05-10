package com.example.gaaapp.Splash

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.Home
import com.example.gaaapp.R

class MainSplash : AppCompatActivity() {
    internal val TIME_OUT = 1500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
                {
                    startActivity(Intent(this@MainSplash, Home::class.java))
                    finish()
                }, TIME_OUT.toLong())
    }

}
