package com.example.mydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar

class StoryDetails : AppCompatActivity() {
    lateinit var toolBarD :androidx.appcompat.widget.Toolbar
    lateinit var backArrowDet:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        toolBarD = findViewById(R.id.tbarD)
        backArrowDet = findViewById(R.id.bArrD)

        backArrowDet.setOnClickListener(){
            var d = Intent(this,MainActivity::class.java)
            startActivity(d)
        }

    }
}