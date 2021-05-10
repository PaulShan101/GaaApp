package com.example.gaaapp.General
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.R


import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.homenav.*


class AboutUs : AppCompatActivity() {





        lateinit var mButtonMap: Button
        lateinit var mEdtSearch: EditText


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_aboutus)
            mButtonMap = findViewById(R.id.mapBtn)
            mEdtSearch = findViewById(R.id.loctionEdt)

            mButtonMap.setOnClickListener {
                val mUrilntent = Uri.parse("geo:0,0?q=${mEdtSearch.text.toString()}")
                val mMaplntent = Intent(Intent.ACTION_VIEW,mUrilntent)
                mMaplntent.setPackage("com.google.android.apps.maps")
                startActivity(mMaplntent)
            }
        }
    }









        /* override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when (item.itemId) {
             R.id.action_donate -> toast("You Selected Donate")
             R.id.action_report -> toast("You Selected Report")
         }
         return super.onOptionsItemSelected(item)
     }*/

        /*  override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.home, fragment)
                .addToBackStack(null)
                .commit()
    }*/


  /*  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }


    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


//menu items

        when (item.itemId) {
            R.id.list1 -> {
                val intent = Intent(this@AboutUs, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.homepage -> {
                val intent = Intent(this@AboutUs, Home::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@AboutUs, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@AboutUs, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@AboutUs, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.signup1 -> {
                val intent = Intent(this@AboutUs, SignUp::class.java)
                startActivity(intent)
            }
            R.id.login1 -> {
                val intent = Intent(this@AboutUs, Login::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }*/










