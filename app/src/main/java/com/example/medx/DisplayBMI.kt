package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DisplayBMI : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_bmi)

        val weight = findViewById<TextView>(R.id.weight)
        val height = findViewById<TextView>(R.id.height)

        val thinimage = findViewById<ImageView>(R.id.thin)
        val healthyimage = findViewById<ImageView>(R.id.healthy)
        val fatimage = findViewById<ImageView>(R.id.fat)

        val heightvalue=intent.getStringExtra("heightvalue")
        val weightvalue=intent.getStringExtra("weightvalue")

        weight.text = weightvalue
        height.text = heightvalue

        val weightval = weightvalue?.toDouble()?.div(100)
        val heightval = heightvalue?.toDouble()?.div(100)
        var bmivalue  = (weightval?.div((heightval!! * heightval)))?.times(100)

        if (bmivalue != null) {
            bmivalue = Math.round(bmivalue * 100.0) / 100.0
        }
        //Toast.makeText(this, bmivalue.toString(),Toast.LENGTH_SHORT).show()
        val bmi = findViewById<TextView>(R.id.bmi)


        val generate = findViewById<TextView>(R.id.generate)

        generate.setOnClickListener {
            bmi.visibility = View.VISIBLE
            bmi.text = bmivalue.toString()

            if (bmivalue != null) {
                if(bmivalue<21)
                {
                    thinimage.setImageResource(R.drawable.thin_image)
                }
                else if(bmivalue>=21 && bmivalue<25)
                {
                    healthyimage.setImageResource(R.drawable.healthy_image)
                }
                else
                {
                    fatimage.setImageResource(R.drawable.fat_image)
                }
            }
        }


        val diet = findViewById<Button>(R.id.diet)

        diet.setOnClickListener {
            val intent = Intent(this,DietPlan::class.java)
            if (bmivalue != null) {
                intent.putExtra("diet",bmivalue.toString())
            }
            startActivity(intent)
        }


    }
}