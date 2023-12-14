package com.example.medx

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medx.databinding.ActivityFetchDocsBinding
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class fetchDocs : AppCompatActivity() {

    lateinit var binding : ActivityFetchDocsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFetchDocsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_fetch_docs)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Fetching Image....")
        progressDialog.setCancelable(false)

        val display = findViewById<ImageView>(R.id.displayImg)
        val fileName=findViewById<EditText>(R.id.filename)
        val fetchImg=findViewById<Button>(R.id.fetch)
        fetchImg.setOnClickListener {

            progressDialog.show()
            val imgeName=fileName.text.toString()
            val storage = FirebaseStorage.getInstance().reference.child("images/$imgeName")

            val localfile = File.createTempFile("tempImage","jpeg")
            storage.getFile(localfile).addOnSuccessListener {

                if(progressDialog.isShowing)
                    progressDialog.dismiss()
                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                display.setImageBitmap(bitmap)

            }.addOnFailureListener {

                if(progressDialog.isShowing)
                    progressDialog.dismiss()
                Toast.makeText(this,"Failes to fetch the Image", Toast.LENGTH_SHORT).show()

            }


        }
    }
}