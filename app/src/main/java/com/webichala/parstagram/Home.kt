package com.webichala.parstagram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.parse.ParseUser

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.logout).setOnClickListener{
            ParseUser.logOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.create_post).setOnClickListener {
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)

        }
    }

}