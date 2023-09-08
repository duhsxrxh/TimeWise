package com.example.timewise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.timewise.databinding.ActivityHomeScreenBinding
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

class HomeScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()

        dateTextView.text = currentDate

        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()

        dayTextView.text = currentDay
    }

    private fun getCurrentDate(): String
    {
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    private fun getCurrentDay(): String
    {
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val currentDay = Date()
        return dayFormat.format(currentDay)
    }
}