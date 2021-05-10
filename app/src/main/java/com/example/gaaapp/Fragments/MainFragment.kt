package com.example.gaaapp.Fragments
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.gaaapp.General.AboutUs
import com.example.gaaapp.Home
import com.example.gaaapp.Lists.MainGaaList
import com.example.gaaapp.Quiz.MainQuizActivity
import com.example.gaaapp.R


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mainfragment.*


class MainFragment : AppCompatActivity() {

//MAIN FRAGMET PAGE TO HELP NAVIGATE AROUND THE FRAGMENTS
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_mainfragment)
        //controls all the fragments for the champions league sec
        val homeFragment = HomeFragment()
        val hurlingFragment = HurlingFragment()
        val footballFragment = FootballFragment()


        makeCurrentFragment(homeFragment)
        //bottom buttons for each section
        button_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home1 -> makeCurrentFragment(homeFragment)
                R.id.hurling1 -> makeCurrentFragment(hurlingFragment)
                R.id.football1 -> makeCurrentFragment(footballFragment)

            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
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
                val intent = Intent(this@MainFragment, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@MainFragment, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@MainFragment, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.homepage -> {
                val intent = Intent(this@MainFragment, Home::class.java)
                startActivity(intent)
            }



        }
        return super.onOptionsItemSelected(item)
    }







}

