package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityProfileScreenBinding

class ProfileScreen : AppCompatActivity()
{

    //activity main XML components
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var profileButton : Button?= null
    var darkModeButton : Button?= null

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