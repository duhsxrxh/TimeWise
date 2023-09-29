package com.example.timewise

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityActScreenBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class ActScreen : AppCompatActivity()
{
    //activity main XML components
    var homeButton : Button?= null
    var overviewButton : Button?= null
    var activityButton : Button?= null
    var profileButton : Button?= null

    lateinit var barChart: BarChart

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityActScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_act_screen)

        //activity main XML components
        homeButton = findViewById(R.id.btnHomeScreen)
        overviewButton = findViewById(R.id.btnCalenderScreen)
        activityButton = findViewById(R.id.btnActivityScreen)
        profileButton = findViewById(R.id.btnProfileScreen)

        bargraph()

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

    private fun bargraph()
    {
        barChart = findViewById(R.id.bar_chart)

        val list: ArrayList<BarEntry> = ArrayList()

        list.add(BarEntry(100f, 100f))
        list.add(BarEntry(101f, 200f))
        list.add(BarEntry(102f, 300f))
        list.add(BarEntry(103f, 400f))
        list.add(BarEntry(104f, 500f))

        val barDataSet = BarDataSet(list, "list")

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        barDataSet.valueTextColor = Color.BLACK

        val barData = BarData(barDataSet)

        barChart.setFitBars(false)

        barChart.data = barData

        barChart.description.text = "Categories"

        barChart.animateY(2000)



    }
}