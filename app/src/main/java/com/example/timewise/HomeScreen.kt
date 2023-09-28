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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timewise.databinding.ActivityHomeScreenBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.LinkedList
import java.util.Locale

class HomeScreen : AppCompatActivity() {

    private val data = arrayOf("Hello")  // Use Kotlin array syntax

    private var counter = 0

    // Activity main XML components
    private var homeButton: Button? = null
    private var overviewButton: Button? = null
    private var activityButton: Button? = null
    private var profileButton: Button? = null
    private var mainScreenText: TextView? = null

    // Inflated view components
    private var btnCreatecategory: Button? = null
    private var inflatedTextCategoryName: EditText? = null
    private var backImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Setting the date
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()
        dateTextView.text = currentDate

        // Setting the day
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()
        dayTextView.text = currentDay

        // Activity main XML components
        mainScreenText = findViewById(R.id.txtCategoryName)
        homeButton = findViewById(R.id.btnHomeScreen)
        overviewButton = findViewById(R.id.btnCalenderScreen)
        activityButton = findViewById(R.id.btnActivityScreen)
        profileButton = findViewById(R.id.btnProfileScreen)

        binding.btnAddCategory.setOnClickListener {
            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.show_pop_up, null)

            // Container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)



            // Display the inflated view
            container.addView(view)

            // Inflated layout components
            btnCreatecategory = view.findViewById(R.id.btnCreateNewCategory)
            inflatedTextCategoryName = view.findViewById(R.id.txtCreateNewCategory)
            backImage = view.findViewById(R.id.createACategoryBackground)

                //Inflated view
            btnCreatecategory?.setOnClickListener {
                // Get the text from the inflated EditText
                val newText = inflatedTextCategoryName?.text.toString()

                // Set the text of the main TextView to the new text
                mainScreenText?.text = newText

                val items = LinkedList<String>()  // Use LinkedList to store items
                items.add(newText)

                // Assuming you have already initialized 'items' and 'counter'
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
                recyclerView.layoutManager = LinearLayoutManager(this)
                val adapter = DemoAdapter(items)
                recyclerView.adapter = adapter

                counter++
                adapter.notifyItemInserted(items.size - 1)



                // Remove the inflated view
                container.removeView(view)
            }
        }

        // Opening profile screen button
        binding.btnProfileScreen.setOnClickListener {
            val profileIntent = Intent(this, ProfileScreen::class.java)
            startActivity(profileIntent)
        }

        // Opening overview screen button
        binding.btnOverviewScreen.setOnClickListener {
            val overviewIntent = Intent(this, Overview::class.java)
            startActivity(overviewIntent)
        }

        // Opening activity screen button
        binding.btnActivityScreen.setOnClickListener {
            val activityIntent = Intent(this, ActScreen::class.java)
            startActivity(activityIntent)
            //finish()
        }
    }

    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    private fun getCurrentDay(): String {
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val currentDay = Date()
        return dayFormat.format(currentDay)
    }
}
