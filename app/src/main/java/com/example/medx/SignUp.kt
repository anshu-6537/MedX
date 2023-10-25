package com.example.medx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.medx.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.next.setOnClickListener {
            val name = binding.entername.text.toString()
            val email = binding.entermail.text.toString()
            val pass = binding.enterpass.text.toString()
            val confrmPass = binding.entercnfrmpass.text.toString()




            if (email.isNotEmpty() && pass.isNotEmpty() && confrmPass.isNotEmpty()) {
                if (pass == confrmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignIn::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password doesnt matches", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields not allowed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}