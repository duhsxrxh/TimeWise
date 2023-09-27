package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.timewise.databinding.ActivityHomeScreenBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeScreen : AppCompatActivity()
{
    //activity main XML components
    var homeButton : Button ?= null
    var overviewButton : Button ?= null
    var activityButton : Button ?= null
    var profileButton : Button ?= null
    var mainScreenText : TextView ?= null

    //Inflated view components
    var btnCreatecategory: Button?= null
    var inflatedTextCategoryName: EditText?= null
    var backImage: ImageView?= null

    @Override
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var recycelerViewCategories = findViewById<RecyclerView>(R.id.recycleViewCategories);

        //setting the date
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()
        dateTextView.text = currentDate

        //setting the day
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()
        dayTextView.text = currentDay

        //activity main XML components
        mainScreenText = findViewById<TextView>(R.id.txtCategoryName)
        homeButton = findViewById<Button>(R.id.btnHomeScreen)
        overviewButton = findViewById<Button>(R.id.btnCalenderScreen)
        activityButton = findViewById<Button>(R.id.btnActivityScreen)
        profileButton = findViewById<Button>(R.id.btnProfileScreen)

        binding.btnAddCategory.setOnClickListener()
        {

            //binding.btnAddCategory.isEnabled = false;

            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.show_pop_up, null)

            //container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)

            //create layout parameters for centering the view
            val layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)


            //set layout params to the view
            view.layoutParams = layoutParams

            //display the inflated view
            container.addView(view)

            @Override
            //inflated layout components
            btnCreatecategory = findViewById(R.id.btnCreateNewCategory)
            inflatedTextCategoryName = findViewById(R.id.txtCreateNewCategory)
            backImage = findViewById(R.id.imageView3)

            btnCreatecategory?.setOnClickListener()
            {
                //Get the text from the inflated EditText
                val newText = inflatedTextCategoryName?.text.toString()

                //Set the text of the main TextView to the new text
                mainScreenText?.text = newText

                //Remove the inflated view
                container.removeView(view)

            }


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

        //opening activity screen button
        binding.btnActivityScreen.setOnClickListener()
        {
            val activityIntent = Intent(this, ActScreen::class.java)
            startActivity(activityIntent)
        }


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