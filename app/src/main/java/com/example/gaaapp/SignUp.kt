package com.example.gaaapp
//AUTHOR:  PAUL SHANAHAN
//VERSION : 1
//DATE : 06/03/2021
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gaaapp.Fragments.MainFragment
import com.example.gaaapp.General.AboutUs
import com.example.gaaapp.Lists.MainGaaList
import com.example.gaaapp.Quiz.MainQuizActivity

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.app_bar_home.*

class SignUp : AppCompatActivity() {



    private var signup_btn: Button?= null
    private var user_email_editText: EditText? = null
    private var user_password_editText:EditText?= null
    private var firebaseAuth: FirebaseAuth? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
//        setSupportActionBar(toolbar)




        signup_btn = findViewById(R.id.signup_btn)
        user_email_editText = findViewById(R.id.user_email)
        user_password_editText = findViewById(R.id.user_password)
        firebaseAuth = FirebaseAuth.getInstance()



        signup_btn?.setOnClickListener {

            //all our code for create new user
            RegisterNewUser()
        }



    }



    private fun RegisterNewUser() {


        var email_text = user_email_editText?.text.toString().trim()
        var passowrd = user_password_editText?.text.toString().trim()


        if (TextUtils.isEmpty(email_text)) {

            Toast.makeText(applicationContext,"This Field Can not be Empty",Toast.LENGTH_SHORT).show()

        }


        else if (TextUtils.isEmpty(passowrd)) {

            Toast.makeText(applicationContext,"This Field Can not be Empty",Toast.LENGTH_SHORT).show()

        }



        else{


            firebaseAuth?.createUserWithEmailAndPassword(email_text,passowrd)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {


                    if (task.isSuccessful) {

                        Toast.makeText(applicationContext,"Account Created",Toast.LENGTH_SHORT).show()
                        val user: FirebaseUser = firebaseAuth!!.currentUser!!


                        user.sendEmailVerification().addOnCompleteListener(object : OnCompleteListener<Void> {
                            override fun onComplete(task: Task<Void>) {

                                if(task.isSuccessful) {

                                    Toast.makeText(applicationContext,"Please Check your Email ",Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@SignUp, Login::class.java))

                                }else {

                                    val error =  task.exception?.message
                                    Toast.makeText(applicationContext,"Error" + error,Toast.LENGTH_SHORT).show()

                                }


                            }


                        })


                    }

                    else {

                        val error = task.exception?.message
                        Toast.makeText(applicationContext,"Error" + error,Toast.LENGTH_SHORT).show()


                    }



                }

            })

        }


    }




    public fun LogIn(view: View) {



        startActivity(Intent(this@SignUp, Login::class.java))
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
                val intent = Intent(this@SignUp, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@SignUp, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@SignUp, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@SignUp, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.homepage -> {
                val intent = Intent(this@SignUp, Home::class.java)
                startActivity(intent)
            }
            R.id.login1 -> {
                val intent = Intent(this@SignUp, Login::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }


}
