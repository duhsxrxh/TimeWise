package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityProfileScreenDarkModeBinding

class ProfileScreenDarkMode : AppCompatActivity()
{
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var darkModeButton : Button?= null
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        val binding = ActivityProfileScreenDarkModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeButton?.findViewById<Button>(R.id.btnHomeScreen)
        overviewButton?.findViewById<Button>(R.id.btnCalenderScreen)
        activityButton?.findViewById<Button>(R.id.btnActivityScreen)
        darkModeButton?.findViewById<Button>(R.id.btnMode)

        //dark mode button
        binding.btnMode.setOnClickListener()
        {
            val overviewIntent = Intent(this, ProfileScreen::class.java)
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