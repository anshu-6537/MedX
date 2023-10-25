package com.example.medx

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(private val imageList : ArrayList<UserImage> , private val context: Context) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image : ImageView = itemView.findViewById(R.id.recycler)
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_doc,parent,false)
            return ImageViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            Glide.with(context).load(imageList[position].userImage).into(holder.image)
        }

        override fun getItemCount(): Int {
            return imageList.size
        }
}