package com.example.medx


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Health_tips : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_tips)
        val readSkin = findViewById<TextView>(R.id.read_skin)
        val readDiet = findViewById<TextView>(R.id.read_diet)
        val readObesity = findViewById<TextView>(R.id.read_obesity)
        val readHairfall = findViewById<TextView>(R.id.read_hairfall)
        val readAcne = findViewById<TextView>(R.id.read_acne)
        val readDental = findViewById<TextView>(R.id.read_dental)
        val readSleep = findViewById<TextView>(R.id.read_sleep)
        val readAsthma = findViewById<TextView>(R.id.read_asthma)
        val readMalnutrition = findViewById<TextView>(R.id.read_malnutrition)
        val readHydrated = findViewById<TextView>(R.id.read_hydrated)
        var s = ""
        var s_cause = ""
        var s_prevent = ""
        val intent = Intent(this, individual_tip::class.java)

        readSkin.setOnClickListener {
            s = getString(R.string.Skin)
            s_cause = getString(R.string.types_skin)
            //Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
            intent.putExtra("name","Skin Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }

        readDiet.setOnClickListener {
            s = getString(R.string.obesity)
            s_cause = getString(R.string.causes_obesity)
            s_prevent = getString(R.string.prevent_obesity)
            intent.putExtra("name","Diet Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }

        readObesity.setOnClickListener {
            s = getString(R.string.obesity)
            s_cause = getString(R.string.causes_obesity)
            s_prevent = getString(R.string.prevent_obesity)
            intent.putExtra("name","Obesity Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }

        readDental.setOnClickListener {
            s = getString(R.string.asthma)
            s_cause = getString(R.string.causes_dental)
            s_prevent = getString(R.string.prevent_dental)
            intent.putExtra("name","Dental Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }
        readSleep.setOnClickListener {
            s = getString(R.string.sleep_cycle)
            s_cause = getString(R.string.ways_cycle)
            intent.putExtra("name","Sleep Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }
        readAcne.setOnClickListener {
            s = getString(R.string.acne)
            s_cause = getString(R.string.cause_acne)
            s_cause = getString(R.string.prevent_acne)
            intent.putExtra("name","Acne Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }
        readHydrated.setOnClickListener {
            s = getString(R.string.hydration)
            s_cause = getString(R.string.causes_hydration)
            s_cause = getString(R.string.prevent_hydration)
            intent.putExtra("name","Hydrated Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
           }
        readAsthma.setOnClickListener {
            s = getString(R.string.asthma)
            s_cause = getString(R.string.causes_asthma)
            s_prevent = getString(R.string.prevent_asthma)
            intent.putExtra("name","Asthma Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }
        readMalnutrition.setOnClickListener {
            s = getString(R.string.malnutrition)
            s_cause = getString(R.string.ways_malnutrition)
            intent.putExtra("name","Nutirition Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }

        readHairfall.setOnClickListener {
            s = getString(R.string.hairfall)
            s_cause = getString(R.string.causes_hairfall)
            s_prevent = getString(R.string.prevent_hairfall)
            intent.putExtra("name","Hairfall Related")
            intent.putExtra("disease", s)
            intent.putExtra("cause", s_cause)
            intent.putExtra("prevent", s_prevent)
            startActivity(intent)
        }

    }
}