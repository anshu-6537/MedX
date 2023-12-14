package com.example.medx

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class home_page1 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page1)


        val upload = findViewById<ImageView>(R.id.uploadFile)
        upload.setOnClickListener {
            startActivity(Intent(this, Upload::class.java))
        }

        val weather = findViewById<ImageView>(R.id.weather)
        weather.setOnClickListener {
            startActivity(Intent(this, FetchTemp::class.java))
        }

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

        val consult = findViewById<ImageView>(R.id.consultDoc)
        consult.setOnClickListener {
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
            val intent = Intent(this, Health_tips::class.java)
            startActivity(intent)
        }

        val health_tips = findViewById<ImageView>(R.id.health_tip)
        health_tips.setOnClickListener {
            val intent = Intent(this, Health_tips::class.java)
            startActivity(intent)
        }

        val test = findViewById<TextView>(R.id.take_test)
        test.setOnClickListener {
            val intent = Intent(this, Self_test::class.java)
            startActivity(intent)
        }

        val read1 = findViewById<TextView>(R.id.read1)
        read1.setOnClickListener {
            Toast.makeText(this, "Click View more", Toast.LENGTH_SHORT).show()
        }

        val read2 = findViewById<TextView>(R.id.read2)
        read2.setOnClickListener {
            Toast.makeText(this, "Click View more", Toast.LENGTH_SHORT).show()
        }


        // ....... NAVIGATION DRAWER .......
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.nav_view)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnOpenDrawer: ImageButton = findViewById(R.id.btnOpenDrawer)
        btnOpenDrawer.setOnClickListener {
            drawerLayout.openDrawer(findViewById(R.id.nav_view));
        }

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.update -> startActivity(Intent(applicationContext, updateData::class.java))

                R.id.privacy -> startActivity(
                    Intent(
                        applicationContext,
                        termsNcondition::class.java
                    )
                )

                R.id.share -> share()

                R.id.upload -> startActivity(Intent(applicationContext, Upload::class.java))

                R.id.rate -> Toast.makeText(applicationContext, "rate", Toast.LENGTH_SHORT).show()

                R.id.logout -> quit()

            }
            true
        }
    }


    private fun share() {
        val intent = Intent(ACTION_SEND)
        val url = "https://github.com/anshu-6537/MedX"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, Checkout this cool app $url")
        val chooser = Intent.createChooser(intent, "Share this app using ...")
        startActivity(chooser)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item))

            return true

        return super.onOptionsItemSelected(item)
    }
    private fun quit() {

        System.exit(0)


    }

}