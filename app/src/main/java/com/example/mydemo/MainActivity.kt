package com.example.mydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("email")

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolBar)
        navigationView = findViewById(R.id.navDrawer)


       setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpDrawer()
        upDateEmailInHandler(email!!)
        drawerClicks()
    }

    private fun drawerClicks() {
       navigationView.setNavigationItemSelectedListener {
           when(it.itemId){
               R.id.homeI ->{
                   drawerLayout.closeDrawer(GravityCompat.START)
                   true 
               }
               R.id.logOut->{
                   finish()
                   var i = Intent(this,Login_Screen::class.java)
                   startActivity(i)
                   true
               }
               else -> true

           }
       }
    }

    private fun upDateEmailInHandler(email: String) {
      val  hraderView = navigationView.getHeaderView(0)
        val textViewEmail = hraderView.findViewById<TextView>(R.id.tv_email)
        textViewEmail.text = email
    }

    private fun setUpDrawer() {
        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }
}