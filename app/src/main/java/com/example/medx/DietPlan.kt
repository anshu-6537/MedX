package com.example.medx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.medx.databinding.ActivityDietPlanBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text
import pl.droidsonroids.gif.GifImageView

class DietPlan : AppCompatActivity() {

    private lateinit var binding: ActivityDietPlanBinding
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_plan)

        var diet = intent.getStringExtra("diet")

        binding= ActivityDietPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(diet!=null) {
            Toast.makeText(this, "Last", Toast.LENGTH_SHORT).show()
            val bmivalue = diet.toDouble()
            diet = bmivalue.toInt().toString()
            readData(diet)
        }
        else
        {
            Toast.makeText(this,"Invalid BMI",Toast.LENGTH_SHORT).show()
        }

    }

    private fun readData(bmi: String) {

        val gif = findViewById<GifImageView>(R.id.gif)
        val breakfast = findViewById<TextView>(R.id.breakfast)
        val midmeal = findViewById<TextView>(R.id.midmeal)
        val lunch = findViewById<TextView>(R.id.lunch)
        val snack = findViewById<TextView>(R.id.snack)
        val dinner = findViewById<TextView>(R.id.dinner)

        database = FirebaseDatabase.getInstance().getReference("BMI")
        database.child(bmi).get().addOnSuccessListener {

            if(it.exists())
            {
                gif.visibility = View.INVISIBLE
                val breakfastval = it.child("Breakfast").value
                val lunchval = it.child("Lunch").value
                val midMealval = it.child("MidMeal").value
                val snackval = it.child("Snacks").value
                val dinnerval = it.child("Dinner").value

                breakfast.text = breakfastval.toString()
                midmeal.text = midMealval.toString()
                lunch.text = lunchval.toString()
                snack.text = snackval.toString()
                dinner.text = dinnerval.toString()


                Toast.makeText(this,"Successfully fetched",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,"Value doesn't exist",Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this,"Data can't be loaded",Toast.LENGTH_SHORT).show()
        }
    }
}