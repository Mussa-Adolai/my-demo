package com.example.mydemo

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessControlContext

class CustomAdapter(val storiesList: ArrayList <Story> , val context : Context) : RecyclerView.Adapter<>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {

    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
    class DataHolder(item : View) : RecyclerView.ViewHolder(item){
        val storyTitle:TextView = item.findViewById(R.id.tvTitle)
        val storyLetter:TextView = item.findViewById(R.id.tvStoryLetter)
        val storySubtitle:TextView = item.findViewById(R.id.tvSubtitle)
        val cardViewCircle:CardView = item.findViewById(R.id.circle)

    }
}