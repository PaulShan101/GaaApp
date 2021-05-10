package com.example.gaaapp.Firebase

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.R
import kotlinx.android.synthetic.main.activity_add.*


class AddActivity : AppCompatActivity() {

    private var myHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        myHelper = DatabaseHelper()
        myHelper!!.open()
    }

    fun addButtonPressed(view: View) {
        val name = name_edittext!!.text.toString()
        val address = address_edittext!!.text.toString()
        val score = score_edittext!!.text.toString()

        myHelper!!.add(name, address, score)

        finish()
    }
}