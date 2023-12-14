package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class intro3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro3)



        val next =findViewById<Button>(R.id.nextBtn)
        next.setOnClickListener {
            val intent = Intent(this,SignupORSignIn::class.java)
            startActivity(intent)
        }
    }
}