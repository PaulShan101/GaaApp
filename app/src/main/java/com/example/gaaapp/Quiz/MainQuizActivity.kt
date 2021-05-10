package com.example.gaaapp.Quiz
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021

//import android.support.v7.app.AppCompatActivity


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.Fragments.MainFragment
import com.example.gaaapp.General.AboutUs
import com.example.gaaapp.Home
import com.example.gaaapp.Lists.MainGaaList
import com.example.gaaapp.R
import com.example.gaaapp.StartPage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.homenav.*
import java.util.*


class MainQuizActivity : AppCompatActivity() {
    // THE START QUIZ AND HIGH SCORE SAVED PAGE
    private var txtHighScore: TextView? = null
    private var user: TextView? = null
    lateinit var app: StartPage
    private var mhighscore: Int = 0
    private var btnChoose: Button? = null
    private var btnUpload: Button? = null
    private var imageView: ImageView? = null
    private var imgFirebase: ImageView? = null
    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST = 71

    //Firebase

    //Firebase
    var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = application as StartPage
//        setSupportActionBar(toolbar)
        app.auth = FirebaseAuth.getInstance()
        user = findViewById(R.id.user_email)
        txtHighScore = findViewById(R.id.highscore)
        loadHighScore()

        btnChoose = findViewById<View>(R.id.btnChoose) as Button
        btnUpload = findViewById<View>(R.id.btnUpload) as Button
        imageView = findViewById<View>(R.id.img) as ImageView
//        imgFirebase = findViewById<View>(com.example.gaaapp.R.id.imgFirebase) as ImageView

        //Firebase init
        storage = FirebaseStorage.getInstance()
        storageReference = storage!!.reference





        //user_email = findViewById(R.id.user_email_text)
        //Toast.makeText(applicationContext,"hello  "  + user_email.toString() +  "Your are Logined Successfly ", Toast.LENGTH_LONG).show()
        //user_email_text = "User Name:-" + user
        user = user_email_text
        user!!.text = "Username:   " +   user_email_text.text
        //user_email_text.text = app.auth
//        navView.getHeaderView(0).user_email_text.text = app.auth.currentUser?.email
        val startQuiz = findViewById<Button>(R.id.startButton)
        startQuiz.setOnClickListener {
            startActivityForResult(
                Intent(applicationContext, MainActivity2::class.java),
                REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val score = data!!.getIntExtra(MainActivity2.FINAL_SCORE, 0)
                if (score > mhighscore) {
                    updateScore(score)
                }
            }
        }
    }

    private fun updateScore(score: Int) {
        mhighscore = score
        txtHighScore!!.text = "My High Score:- $mhighscore"

        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(HIGH_SCORE, mhighscore)
        editor.apply()

    }

    private fun loadHighScore() {
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        mhighscore = preferences.getInt(HIGH_SCORE, 0)
        txtHighScore!!.text = "My High Score:- $mhighscore"

    }

    companion object {

        private val REQUEST_CODE = 1
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.list1 -> {
                val intent = Intent(this@MainQuizActivity, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.homepage -> {
                val intent = Intent(this@MainQuizActivity, Home::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@MainQuizActivity, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@MainQuizActivity, MainFragment::class.java)
                startActivity(intent)
            }



        }
        return super.onOptionsItemSelected(item)
    }




    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }








}