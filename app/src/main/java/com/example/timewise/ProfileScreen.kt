package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityProfileScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ProfileScreen : AppCompatActivity()
{
    val database = Firebase.database
    //val timewiseRef = database.getReference("User Details")

    //activity main XML components
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var profileButton : Button?= null
    var darkModeButton : Button?= null
    //val emailTextView = findViewById<TextView>(R.id.tvEmail)
    //val usernameTextView = findViewById<TextView>(R.id.tvName)


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //activity main XML components
        homeButton?.findViewById<Button>(R.id.btnHomeScreen)
        overviewButton?.findViewById<Button>(R.id.btnCalenderScreen)
        activityButton?.findViewById<Button>(R.id.btnActivityScreen)
        profileButton?.findViewById<Button>(R.id.btnProfileScreen)
        darkModeButton?.findViewById<Button>(R.id.btnMode)

        //dark mode button
        binding.btnMode.setOnClickListener()
        {
            val overviewIntent = Intent(this, ProfileScreenDarkMode::class.java)
            startActivity(overviewIntent)
        }


        //opening overview screen button
        binding.btnOverviewScreen.setOnClickListener()
        {
            val overviewIntent = Intent(this, Overview::class.java)
            startActivity(overviewIntent)
        }

        //opening activity screen button
        binding.btnActivityScreen.setOnClickListener()
        {
            val activityIntent = Intent(this, ActScreen::class.java)
            startActivity(activityIntent)
        }

        //opening home screen button
        binding.btnHomeScreen.setOnClickListener()
        {
            val homeIntent = Intent(this, HomeScreen::class.java)
            startActivity(homeIntent)
        }


    }
}