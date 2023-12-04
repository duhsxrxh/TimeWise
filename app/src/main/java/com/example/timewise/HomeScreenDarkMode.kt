package com.example.timewise

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timewise.databinding.ActivityHomeScreenDarkModeBinding
import com.example.timewise.view.UserAdapter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.LinkedList
import java.util.Locale

class HomeScreenDarkMode : AppCompatActivity()
{


    // Activity main XML components
    private var homeButton: Button? = null
    private var overviewButton: Button? = null
    private var activityButton: Button? = null
    private var profileButton: Button? = null
    private var mainScreenText: TextView? = null
    private var setGoals:Button?=null
    private var enterGoals:Button?=null

    // Inflated view components
    private var btnCreateNewCategory: Button? = null
    private var inflatedTextCategoryName: EditText? = null
    private var backImage: ImageView? = null
    private lateinit var cardView:CardView
    private  lateinit var userList : ArrayList<String>
    private lateinit var userAdapter: UserAdapter
    private var txtCreateNewCategory: EditText?= null

    //daily goals inflated view
    var createDailyGoals: Button ?= null

    //timesheet
    var createTimeSheetEntry:Button?=null

    var TAG = "myAct"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeScreenDarkModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = LinkedList<String>()  // Use LinkedList to store items
        var count = 0;

        // Setting the date
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()
        dateTextView.text = currentDate

        // Setting the day
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()
        dayTextView.text = currentDay

        // Activity main XML components
        homeButton = findViewById(R.id.btnHomeScreen)
        overviewButton = findViewById(R.id.btnCalenderScreen)
        activityButton = findViewById(R.id.btnActivityScreen)
        profileButton = findViewById(R.id.btnProfileScreen)
        btnCreateNewCategory = findViewById(R.id.btnCreateNewCategory)

        //set goals
        setGoals = findViewById(R.id.btnSetGoals)

        //time sheet
        createTimeSheetEntry = findViewById(R.id.btnCreateTimeSheetEntry)

        binding.btnCreateTimeSheetEntry.setOnClickListener()
        {
            val profileIntent = Intent(this, SubtasksScreen::class.java)
            startActivity(profileIntent)
        }


        binding.btnSetGoals.setOnClickListener()
        {
            val newInflater = LayoutInflater.from(applicationContext)
            val setGoalsView = newInflater.inflate(R.layout.setgoals, null)

            //container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)

            val layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)


            setGoalsView.layoutParams = layoutParams

            //display the inflated view
            container.addView(setGoalsView)

            //inflated layout components
            enterGoals = findViewById(R.id.btnEnterDailyGoals)

            enterGoals?.setOnClickListener()
            {
                /*//get the text from the inflated editText and set it to the main text view
                val t = inflatedtext?.text
                text?.setText(t)

                button?.isEnabled = true*/

                //remove the inflated view
                container.removeView(setGoalsView)
            }

        }

        binding.btnAddCategory.setOnClickListener {

            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.show_pop_up, null)

            // Container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)


            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)

            view.layoutParams = layoutParams

            // Display the inflated view
            container.addView(view)

            // Inflated layout components
            btnCreateNewCategory = view.findViewById(R.id.btnCreateNewCategory)
            inflatedTextCategoryName = view.findViewById(R.id.txtCreateNewCategory)

            // Assuming you have already initialized 'items' and 'counter'
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)

            val items = ArrayList<String>()

            //Inflated view
            btnCreateNewCategory?.setOnClickListener {

                items.add(inflatedTextCategoryName?.text.toString())

                recyclerView.layoutManager = LinearLayoutManager(this)
                val adapter = com.example.timewise.DemoAdapter(items)
                recyclerView.adapter = adapter

                btnCreateNewCategory?.setOnClickListener { view ->
                    items.add(inflatedTextCategoryName?.text.toString())
                    count++
                    adapter.notifyItemInserted(items.size - 1)
                }

                val items = ArrayList<String>()
                items.add(inflatedTextCategoryName?.text.toString())

                // Remove the inflated view
                container.removeView(view)
            }


        }


        // Opening profile screen button
        binding.btnProfileScreen.setOnClickListener {
            val profileIntent = Intent(this, ProfileScreenDarkMode::class.java)
            startActivity(profileIntent)
        }

        // Opening overview screen button
        binding.btnOverviewScreen.setOnClickListener {
            val overviewIntent = Intent(this, OverviewDarkMode::class.java)
            startActivity(overviewIntent)
        }

        // Opening activity screen button
        binding.btnActivityScreen.setOnClickListener {
            val activityIntent = Intent(this, ActScreenDarkMode::class.java)
            startActivity(activityIntent)
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
