package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class home_page1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page1)

        val notification = findViewById<ImageView>(R.id.notification)
        notification.setOnClickListener {
            val intent = Intent(this, Notification::class.java)
            startActivity(intent)
        }

        val update = findViewById<TextView>(R.id.updateProfile)
        update.setOnClickListener {
            val intent = Intent(this, updateData::class.java)
            startActivity(intent)
        }

        val consult = findViewById<ImageView>(R.id.consult_doc)
        update.setOnClickListener {
            val intent = Intent(this, ConsultDoctor::class.java)
            startActivity(intent)
        }

        val diet = findViewById<ImageView>(R.id.dietplan)
        diet.setOnClickListener {
            val intent = Intent(this, EnterHeightandWeight::class.java)
            startActivity(intent)
        }

        val view_more = findViewById<TextView>(R.id.view_more)
        view_more.setOnClickListener {
            val intent =Intent(this,Health_tips::class.java)
            startActivity(intent)
        }

        val test = findViewById<TextView>(R.id.take_test)
        test.setOnClickListener {
            val intent = Intent(this,Self_test::class.java)
            startActivity(intent)
        }
    }
}