package com.example.gaaapp
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021

//import com.example.gaaapp.Firebase.StoragePic


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.gaaapp.Firebase.MainActivity
import com.example.gaaapp.Firebase.MainPics
import com.example.gaaapp.Fragments.MainFragment
import com.example.gaaapp.General.AboutUs
import com.example.gaaapp.Lists.MainGaaList
import com.example.gaaapp.Lists.WinnersList
import com.example.gaaapp.Quiz.MainQuizActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.homenav.*
import kotlinx.android.synthetic.main.nav_header_home.*
import kotlinx.android.synthetic.main.nav_header_home.view.*


class Home : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener {


    lateinit var ft: FragmentTransaction
    lateinit var auth: FirebaseAuth
    lateinit  var app : StartPage



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homenav)
       app = application as StartPage
//      setSupportActionBar(toolbar)
     //user_email_text.text = app.auth.currentUser?.email
        //val currentUser1 = firebase.currentUser.user_email
      //  val user: FirebaseUser = firebaseAuth?.currentUser!!.email.
         //NAV DRAWER TOOGLE IN AND OUT
//        user_email_text.text = app.auth.currentUser?.email
        getSupportActionBar()?.hide()

        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //navView.getHeaderView(0).nav_email_text.text = user_email?.text
        ft = supportFragmentManager.beginTransaction()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {



        when (item.itemId) {


            R.id.list -> {
                val intent = Intent(this@Home, MainGaaList::class.java)
                startActivity(intent)
            }
            R.id.nav_aboutus -> {
                val intent = Intent(this@Home, AboutUs::class.java)
                startActivity(intent)
            }



            R.id.history -> {
                val intent = Intent(this@Home, HistoryMain::class.java)
                startActivity(intent)
            }

            R.id.profile -> {
                val intent = Intent(this@Home, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.login_btn -> {
                val intent = Intent(this@Home, Login::class.java)
                startActivity(intent)
            }
           R.id.signup_btn -> {
                val intent = Intent(this@Home, SignUp::class.java)
                startActivity(intent)
            }
           R.id.storage_btn -> {
                val intent = Intent(this@Home, MainPics::class.java)
                startActivity(intent)
            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onBackPressed() {
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
                val intent = Intent(this@Home, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@Home, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@Home, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@Home, MainFragment::class.java)
                startActivity(intent)
            }

            R.id.winlist -> {
                val intent = Intent(this@Home, WinnersList::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }



}
