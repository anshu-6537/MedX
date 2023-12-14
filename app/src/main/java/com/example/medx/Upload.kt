package com.example.medx


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Upload : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_image)
        val upload =findViewById<Button>(R.id.upimg)

        upload.setOnClickListener {
            startActivity(Intent(this,uploadImage::class.java))
        }

        val fetch=findViewById<Button>(R.id.fetchimg)

        fetch.setOnClickListener {
            startActivity(Intent(this,fetchDocs::class.java))
        }

        val back=findViewById<ImageButton>(R.id.back)

        back.setOnClickListener {
            startActivity(Intent(this,home_page1::class.java))
        }
    }
}