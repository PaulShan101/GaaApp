package com.example.gaaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.gaaquizapp.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_history_main.*

class History1 : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history1)

        relGenerate.setOnTouchListener(object : OnSwipeTouchListener(this@History1) {

            override fun onSwipeTop() {
                super.onSwipeTop()
                  Toast.makeText(this@History1,"Top is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                //    Toast.makeText(this@MainActivity,"Bottom is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(this@History1,"left is clicked", Toast.LENGTH_LONG).show()
                val intent= Intent(this@History1,History1::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                val intent= Intent(this@History1,HistoryMain::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)

                Toast.makeText(this@History1,"Left is clicked", Toast.LENGTH_LONG).show()
                //  Toast.makeText(this@MainActivity,"right is clicked",Toast.LENGTH_LONG).show()
            }
        })

        relPrint.setOnTouchListener(object : OnSwipeTouchListener(this@History1) {

            override fun onSwipeTop() {
                super.onSwipeTop()
                //    Toast.makeText(this@MainActivity,"Top is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeBottom() {
                super.onSwipeBottom()
                //  Toast.makeText(this@MainActivity,"Bottom is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                //   Toast.makeText(this@MainActivity,"Left is clicked",Toast.LENGTH_LONG).show()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()

                val intent= Intent(this@History1,HistoryMain::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)

                Toast.makeText(this@History1,"Left is clicked", Toast.LENGTH_LONG).show()
            }
        })



    }
}