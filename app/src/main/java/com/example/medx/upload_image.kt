package com.example.medx


import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class upload_image : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var btnSelect: Button
    private lateinit var btnUpload: Button

    private var  storageRef = Firebase.storage
    private lateinit var uri:Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_image)

        storageRef = FirebaseStorage.getInstance()

        image = findViewById(R.id.firebaseimg)
        btnSelect = findViewById(R.id.selimg)
        btnUpload = findViewById(R.id.upimg)

        val gallerImg = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                image.setImageURI(it)
                uri=it!!
            })

        btnSelect.setOnClickListener {
            gallerImg.launch("image/*")
        }
        btnUpload.setOnClickListener {

            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Uploading File...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            storageRef.getReference("images").child(System.currentTimeMillis().toString())
                .putFile(uri)
                .addOnSuccessListener{ task ->
                    task.metadata!!.reference!!.downloadUrl
                        .addOnSuccessListener {

                            val userId = FirebaseAuth.getInstance().currentUser!!.uid

                            val mapImage = mapOf(
                                "url" to it.toString()
                            )

                            val databaseReference = FirebaseDatabase.getInstance().getReference("userImages")
                            databaseReference.child(userId).setValue(mapImage)
                                .addOnSuccessListener {
                                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                                    if (progressDialog.isShowing) progressDialog.dismiss()
                                }
                                .addOnFailureListener { error ->
                                    if(progressDialog.isShowing) progressDialog.dismiss()
                                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                                }
                        }
                }
            val nextbtn = findViewById<Button>(R.id.nextimg)
            nextbtn.setOnClickListener {

                val intent = Intent(this,fetchDocs::class.java)
                startActivity(intent)
            }
        }
    }
}













//        selImg.setOnClickListener{
//
//            Toast.makeText(this,"selected",Toast.LENGTH_SHORT).show()
//            selectImage()
//        }
//
//        upImg.setOnClickListener{
//            Toast.makeText(this,"uploading",Toast.LENGTH_SHORT).show()
//            uploadImage()
//        }
//    }
//
//    private fun uploadImage() {
//
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Uploading File...")
//        progressDialog.setCancelable(false)
//        progressDialog.show()
//
//        val formatter = SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss", Locale.getDefault())
//        val now= Date()
//        val fileName = formatter.format(now)
//        val storageReference = FirebaseStorage.getInstance().getReference("image/$fileName")
//
//        storageReference.putFile(imageUri).
//                addOnSuccessListener {
//
//                    binding.firebaseimg.setImageURI(null)
//                    Toast.makeText(this, "Successfully uploaded", Toast.LENGTH_SHORT).show()
//                    if (progressDialog.isShowing) progressDialog.dismiss()
//                }.addOnFailureListener{
//
//                    if(progressDialog.isShowing) progressDialog.dismiss()
//                    Toast.makeText(this, "Task Failed", Toast.LENGTH_SHORT).show()
//
//                }
//
//    }
//
//    private fun selectImage() {
//
//
//        val intent = Intent()
//        intent.type="image/*"
//        intent.action=Intent.ACTION_GET_CONTENT
//
//        startActivityForResult(intent,100)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//
//        if(requestCode==100 && resultCode== RESULT_OK){
//            Toast.makeText(this,"picked",Toast.LENGTH_LONG).show()
//            imageUri= data?.data!!
//            binding.firebaseimg.setImageURI(imageUri)
//        }
//
//    }
//}