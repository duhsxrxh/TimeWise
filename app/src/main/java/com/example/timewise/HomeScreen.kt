package com.example.timewise

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.timewise.databinding.ActivityHomeScreenBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeScreen : AppCompatActivity()
{
    //activity main XML components
    var button : Button ?= null
    var text : TextView ?= null


    //Inflated view components
    var viewButton: Button?= null
    var inflatedtext: EditText?= null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting the date
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()
        dateTextView.text = currentDate

        //setting the day
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()
        dayTextView.text = currentDay

        //activity main XML components
        text?.findViewById<TextView>(R.id.txtCategoryName)

        binding.btnAddCategory.setOnClickListener()
        {
            binding.btnAddCategory.isEnabled = false;

            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.show_pop_up, null)

            //container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)

            //create layout parameters for ventering the view
            val layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)

            //set layout params to the view
            view.layoutParams = layoutParams

            //display the inflated view
            container.addView(view)

            //inflated layout components
            viewButton = findViewById(R.id.btnCreateNewCategory)
            inflatedtext = findViewById(R.id.txtCreateNewCategory)

            viewButton?.setOnClickListener()
            {
                //get the text from the inflated editText and set it to the main text view
                val t = inflatedtext?.text
                text?.setText(t)

                button?.isEnabled = true

                //remove the inflated view
                container.removeView(view)
            }


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