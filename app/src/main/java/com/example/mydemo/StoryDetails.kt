package com.example.mydemo

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar

class StoryDetails : AppCompatActivity() {
    lateinit var toolBarD :androidx.appcompat.widget.Toolbar
    lateinit var tvdescription : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)


        toolBarD = findViewById(R.id.tbarD)
        tvdescription = findViewById(R.id.tvDisc)

        setSupportActionBar(toolBarD)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var title = intent.getStringExtra("title")
        var description = intent.getStringExtra("disc")

        toolBarD.title = title
        toolBarD.setNavigationOnClickListener {
            onBackPressed()
        }
        tvdescription.text = description
        tvdescription.movementMethod = ScrollingMovementMethod()






    }
}