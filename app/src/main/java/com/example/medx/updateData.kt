package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class updateData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        val back=findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            val intent= Intent(this,home_page1::class.java)
            startActivity(intent)
        }

        val update=findViewById<Button>(R.id.update)
        update.setOnClickListener {
            Toast.makeText(this,"Request sent to update Data",Toast.LENGTH_SHORT).show()
        }
    }
}