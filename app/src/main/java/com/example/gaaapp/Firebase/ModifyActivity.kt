package com.example.gaaapp.Firebase


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.R
import kotlinx.android.synthetic.main.activity_add.*


class ModifyActivity : AppCompatActivity() {

    private var ID: String = ""

    private var myHelper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)

        myHelper = DatabaseHelper()
        myHelper!!.open()

        val intent = intent
        ID = intent.getStringExtra("id")!!
        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("address")
        val sc = intent.getStringExtra("score")

        name_edittext!!.setText(name)
        address_edittext!!.setText(desc)
        score_edittext!!.setText(sc)
    }

    private fun returnToMainActivity() {
        finish()
    }

    fun updateButtonPressed(view: View) {
        val name = name_edittext!!.text.toString()
        val address = address_edittext!!.text.toString()
        val score = score_edittext!!.text.toString()

        myHelper!!.update(ID, name, address, score)

        returnToMainActivity()
    }

    fun deleteButtonPressed(view: View) {
        myHelper!!.delete(ID)
        returnToMainActivity()
    }
}
