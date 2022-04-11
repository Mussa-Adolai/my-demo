package com.example.mydemo

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import kotlin.random.Random

class CustomAdapter(val storiesList: ArrayList <Story> , val context : Context)
    : RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {

        val dataHolder = DataHolder (LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_layuot,parent,false))

        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {

        val story = storiesList[position]
        holder.storyLetter.text = story.title.first().toString()
        holder.storySubtitle.text = story.subtitle
        holder.storyTitle.text = story.title

        generateColors(holder,position)
    }

    private fun generateColors(holder: DataHolder,position: Int){
      val r = java.util.Random()
        val red = r.nextInt(255 + position)
        val green = r.nextInt(255-position+1)
        val blue = r.nextInt(255+position+1)
        holder.cardViewCircle.setCardBackgroundColor(Color.rgb(red, green, blue))

    }

    override fun getItemCount(): Int {
       return storiesList.size
    }

    class DataHolder(item : View) : RecyclerView.ViewHolder(item){
        val storyTitle:TextView = item.findViewById(R.id.tvTitle)
        val storyLetter:TextView = item.findViewById(R.id.tvStoryLetter)
        val storySubtitle:TextView = item.findViewById(R.id.tvSubtitle)
        val cardViewCircle:CardView = item.findViewById(R.id.circle)

    }
}