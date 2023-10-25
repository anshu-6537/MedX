package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val back = findViewById<ImageView>(R.id.back_button)
        back.setOnClickListener {
            val intent = Intent(this, home_page1::class.java)
            startActivity(intent)
        }
    }
}