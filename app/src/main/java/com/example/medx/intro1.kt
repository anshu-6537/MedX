package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class intro1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1)

        val nextbutton =findViewById<Button>(R.id.nextBtn)
        nextbutton.setOnClickListener {
            val intent = Intent(this, intro2::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this,SignupORSignIn::class.java)
            startActivity(intent)
        }

    }
}