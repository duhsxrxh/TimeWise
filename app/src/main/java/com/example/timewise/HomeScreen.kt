package com.example.timewise

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.timewise.databinding.ActivityHomeScreenBinding
import com.example.timewise.view.UserAdapter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeScreen : AppCompatActivity() {


    var count = 0;

    // Activity main XML components
    private var homeButton: Button? = null
    private var overviewButton: Button? = null
    private var activityButton: Button? = null
    private var profileButton: Button? = null
    private var mainScreenText: TextView? = null

    // Inflated view components
    private var btnCreateNewCategory: Button? = null
    private var inflatedTextCategoryName: EditText? = null
    private var backImage: ImageView? = null
    private lateinit var cardView:CardView
    private  lateinit var userList : ArrayList<String>
    private lateinit var userAdapter: UserAdapter

    var TAG = "myAct"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< HEAD
=======
        val items = LinkedList<String>()  // Use LinkedList to store items

        items.add("Code It")

        // Assuming you have already initialized 'items' and 'counter'
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DemoAdapter(items)
        recyclerView.adapter = adapter

        findViewById<View>(R.id.btnAddCategory).setOnClickListener { view ->
            items.add(data[counter % 3])
            counter++
            adapter.notifyItemInserted(items.size - 1)
        }

>>>>>>> parent of bb50ab0 (push)
        // Setting the date
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val currentDate = getCurrentDate()
        dateTextView.text = currentDate

        // Setting the day
        val dayTextView = findViewById<TextView>(R.id.dayTextView)
        val currentDay = getCurrentDay()
        dayTextView.text = currentDay

        // Activity main XML components
<<<<<<< HEAD
=======
        mainScreenText = findViewById(R.id.categoryCardName)
>>>>>>> parent of bb50ab0 (push)
        homeButton = findViewById(R.id.btnHomeScreen)
        overviewButton = findViewById(R.id.btnCalenderScreen)
        activityButton = findViewById(R.id.btnActivityScreen)
        profileButton = findViewById(R.id.btnProfileScreen)
        btnCreateNewCategory = findViewById(R.id.btnCreateNewCategory)

        binding.btnAddCategory.setOnClickListener {

            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.show_pop_up, null)
            // Container is where we are adding the view
            val container = findViewById<ConstraintLayout>(R.id.homeScreenLayout)

<<<<<<< HEAD
            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)

            view.layoutParams = layoutParams
=======
           /* // Create layout parameters for centering the view
            val layoutParams = ConstraintLayout.LayoutParams(
                //ConstraintLayout.LayoutParams.WRAP_CONTENT,
                //ConstraintLayout.LayoutParams.WRAP_CONTENT
            )*/

            // Set layout params to the view
            //view.layoutParams = layoutParams
>>>>>>> parent of bb50ab0 (push)

            // Display the inflated view
            container.addView(view)

            // Inflated layout components
<<<<<<< HEAD
            btnCreateNewCategory = view.findViewById(R.id.btnCreateNewCategory)


            //Inflated view
            btnCreateNewCategory?.setOnClickListener {

                Log.d(TAG, "create button clicked")
                inflatedTextCategoryName = view.findViewById(R.id.txtCreateNewCategory)
                cardView = view.findViewById(R.id.cards)

                val items = ArrayList<String>()
                val cards = ArrayList<CardView>()

                items.add(inflatedTextCategoryName?.text.toString())
                cards.add(cardView)
=======
            btnCreatecategory = view.findViewById(R.id.btnCreateNewCategory)
            inflatedTextCategoryName = view.findViewById(R.id.txtCreateNewCategory)
            backImage = view.findViewById(R.id.createACategoryBackground)

            btnCreatecategory?.setOnClickListener {
                // Get the text from the inflated EditText
                val newText = inflatedTextCategoryName?.text.toString()

                // Set the text of the main TextView to the new text
                mainScreenText?.text = newText

                // Remove the inflated view
>>>>>>> parent of bb50ab0 (push)
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
