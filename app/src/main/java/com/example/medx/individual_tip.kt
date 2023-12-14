package com.example.medx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class individual_tip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_tip)

        val name=intent.getStringExtra("name")
        val disease=intent.getStringExtra("disease")
        val cause=intent.getStringExtra("cause")
        val prevent=intent.getStringExtra("prevent")
        val Rid= intent.getIntExtra("Rid",-1)


        val nameDisease=findViewById<TextView>(R.id.nameBox)
        val desc=findViewById<TextView>(R.id.desc)
        val causeText=findViewById<TextView>(R.id.causes_text)
        val preventText=findViewById<TextView>(R.id.prevent_text)
        val setPic=findViewById<ImageView>(R.id.pic)

        nameDisease.text=name
        desc.text=disease
        causeText.text=cause
        preventText.text=prevent
        setPic.setImageResource(Rid)


    }
}


