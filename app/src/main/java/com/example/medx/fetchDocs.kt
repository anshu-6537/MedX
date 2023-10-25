package com.example.medx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class fetchDocs : AppCompatActivity() {

    private lateinit var recyclervire : RecyclerView
    private lateinit var imageList: ArrayList<UserImage>
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_docs)

        recyclervire= findViewById(R.id.recycler)
        recyclervire.layoutManager = LinearLayoutManager(this)

        imageList = arrayListOf()

        databaseReference = FirebaseDatabase.getInstance().getReference("userImages")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dataSnapshot in snapshot.children){
                        val image = dataSnapshot.getValue(UserImage::class.java)
                        imageList.add(image!!)
                    }
                    recyclervire.adapter = ImageAdapter(imageList , this@fetchDocs)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@fetchDocs,error.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
}