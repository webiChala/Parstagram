package com.webichala.parstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseObject
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

        findViewById<Button>(R.id.login_button).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            loginUser(username, password)
        }

        findViewById<Button>(R.id.signUp_btn).setOnClickListener {
            val username = findViewById<EditText>(R.id.et_username).text.toString()
            val password = findViewById<EditText>(R.id.et_password).text.toString()
            signUpUser(username, password)
        }




    }

    private fun signUpUser(username:String, password: String) {
        val user = ParseUser()
        user.setUsername(username)
        user.setPassword(password)

        user.signUpInBackground {e ->
            if (e == null){
                //user has successfully signin
                goToMainActivity()
            } else{
                e.printStackTrace()
                Toast.makeText(this, "Sign Up wasn't successful! Try again!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loginUser(username:String, password: String){

        ParseUser.logInInBackground(username, password, ({user, e->
            if (user!=null) {
                Log.i(TAG, "Successfully login user")
                goToMainActivity()
            }else{
                e.printStackTrace()
                Toast.makeText(this, "Error logging in", Toast.LENGTH_SHORT).show()
            }
        }))

    }

    private fun goToMainActivity(){
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    companion object{
        const val TAG = "LoginActivity"
    }
}