package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignupORSignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_orsign_in)

        val btn_click_next = findViewById<Button>(R.id.login)
        btn_click_next.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)

        }
        val btn_click_skip = findViewById<Button>(R.id.create)
        btn_click_skip.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
}