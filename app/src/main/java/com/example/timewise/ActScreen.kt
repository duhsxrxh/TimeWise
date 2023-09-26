package com.example.timewise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.timewise.databinding.ActivityActScreenBinding

class ActScreen : AppCompatActivity()
{
    //activity main XML components
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var profileButton : Button?= null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityActScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_act_screen)

        //activity main XML components
        homeButton?.findViewById<Button>(R.id.btnHomeScreen)
        overviewButton?.findViewById<Button>(R.id.btnCalenderScreen)
        activityButton?.findViewById<Button>(R.id.btnActivityScreen)
        profileButton?.findViewById<Button>(R.id.btnProfileScreen)

        //opening home screen button
        binding.btnHomeScreen.setOnClickListener()
        {
            val homeIntent = Intent(this, HomeScreen::class.java)
            startActivity(homeIntent)
        }

        //opening profile screen button
        binding.btnProfileScreen.setOnClickListener()
        {
            val profileIntent = Intent(this, ProfileScreen::class.java)
            startActivity(profileIntent)
        }

        //opening overview screen button
        binding.btnOverviewScreen.setOnClickListener()
        {
            val overviewIntent = Intent(this, Overview::class.java)
            startActivity(overviewIntent)
        }
    }
}