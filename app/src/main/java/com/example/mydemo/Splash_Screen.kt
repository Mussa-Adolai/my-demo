package com.example.mydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        MovetoLoginScreen()
    }
    fun MovetoLoginScreen(){
        Handler(Looper.myLooper()!!).postDelayed({

         finish()
         val i = Intent(this,Login_Screen::class.java)
            startActivity(i)

        },3000)
    }
}