package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityProfileScreenDarkModeBinding

class ProfileScreenDarkMode : AppCompatActivity()
{
    var darkModeButton : Button?= null
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        val binding = ActivityProfileScreenDarkModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        darkModeButton?.findViewById<Button>(R.id.btnMode)

        //dark mode button
        binding.btnMode.setOnClickListener()
        {
            val overviewIntent = Intent(this, ProfileScreen::class.java)
            startActivity(overviewIntent)
        }

    }
}