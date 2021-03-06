package com.example.mydemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navigationView: NavigationView
    lateinit var recyclerView: RecyclerView
    lateinit var btnAddStory: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val email = intent.getStringExtra("email")

        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar = findViewById(R.id.toolBar)
        navigationView = findViewById(R.id.navDrawer)
        recyclerView = findViewById(R.id.storiesRecycle)
        btnAddStory = findViewById(R.id.btnAddStory)


       setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpDrawer()
        upDateEmailInHandler(email!!)
        drawerClicks()
        openAddStoryActivity()
        displayStories()
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
      val  headerView = navigationView.getHeaderView(0)
        val textViewEmail = headerView.findViewById<TextView>(R.id.tv_email)
        textViewEmail.text = email
    }

    private fun  setUpDrawer() {
        val toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {    //burger Shape
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }
    private fun openAddStoryActivity(){
        btnAddStory.setOnClickListener {
            val i = Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }


    }

    private fun displayStories(){
        var storiesArray = ArrayList<Story>()
        storiesArray.add(Story("This Is My First Story",
            "This Is Subtitle",
                "Welcome To My First StoryWelcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First StoryWelcome To My First Story " +
                        "Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story  Welcome To My First Story Welcome To My First Story" +
                        " Welcome To My First Story Welcome To My First Story Welcome To My First Story  Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story  Welcome To My First Story  Welcome To My First Story  Welcome To My First Story  Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story Welcome To My First Story  Welcome To My First Storyyy  "))

        storiesArray.add(Story("This Is My Second Story",
            "This Is Subtitle",
                "Welcome To My Second Story"))

        storiesArray.add(Story("This Is My Third Story",
            "This Is Subtitle",
                "Welcome To My Third Story"))

        storiesArray.add(Story("This Is My Third Story",
            "This Is Subtitle",
                "Welcome To My Third Story"))

        storiesArray.add(Story("This Is My Third Story",
            "This Is Subtitle",
                "Welcome To My Third Story"))

       storiesArray.add(Story("This Is My Third Story",
            "This Is Subtitle",
                "Welcome To My Third Story"))

        storiesArray.add(Story("This Is My Third Story",
                    "This Is Subtitle",
                        "Welcome To My Third Story"))

        storiesArray.add(Story("This Is My Third Story",
                            "This Is Subtitle",
                                "Welcome To My Third Story"))

        storiesArray.add(Story("This Is My Third Story",
                            "This Is Subtitle",
                                "Welcome To My Third Story"))

        val customAdapter  = CustomAdapter(storiesArray,this)

        recyclerView.adapter = customAdapter


    }
}