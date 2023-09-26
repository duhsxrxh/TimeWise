package com.example.timewise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.timewise.databinding.ActivityOverviewBinding

class Overview : AppCompatActivity()
{

    //activity main XML components
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var profileButton : Button?= null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_overview)

        //activity main XML components
        homeButton?.findViewById<Button>(R.id.btnHomeScreen)
        overviewButton?.findViewById<Button>(R.id.btnCalenderScreen)
        activityButton?.findViewById<Button>(R.id.btnActivityScreen)
        profileButton?.findViewById<Button>(R.id.btnProfileScreen)

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

        //opening profile screen button
        binding.btnProfileScreen.setOnClickListener()
        {
            val profileIntent = Intent(this, ProfileScreen::class.java)
            startActivity(profileIntent)
        }


    }
}