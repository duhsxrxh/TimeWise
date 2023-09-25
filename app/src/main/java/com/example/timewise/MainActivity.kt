package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    //activity main xml components
    var button : Button? = null
    var text : TextView? = null

    //inflated view components
    var viewButton: Button?= null
    var inflateText: EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //variables for the text fields
        val username = findViewById<EditText>(R.id.editTextTextUsername)
        val password = findViewById<EditText>(R.id.editTextTextPassword)

        //trying to change button color
        //signIn.setBackgroundColor(ContextCompat.getColor(this, R.color.buttongreen))

        //onclick listener for the sign in button
        binding.btnSignIn.setOnClickListener()
        {//doesn't let users log in without filling in the required fields
            if (username.text.isNullOrBlank()&&password.text.isNullOrBlank())
            {
                Toast.makeText(this, "Please fill in your details before continuing", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val message: String = binding.editTextTextUsername.text.toString() + " Is Logged In"

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                var sendIntent = Intent(this, HomeScreen :: class.java)

                //takes users to the Home Screen
                startActivity(sendIntent)
            }

        }

        binding.txtSignup.setOnClickListener()
        {
            var sendIntent = Intent(this, HomeScreen :: class.java)

            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }

        //super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //activity main xml components
        button = findViewById(R.id.btnAddSubCategory)
        text = findViewById(R.id.txtCategoryName)

        button?.setOnClickListener()
        {
            //disable button bc it freezes
            button?.isEnabled = false

            val inflater = LayoutInflater.from(applicationContext)
            val view = inflater.inflate(R.layout.addcategorylayout, null)

            //container is where we are adding the view
            val container = findViewById<RelativeLayout>(R.id.homeScreenLayout)

            //create layout parameters for centering the view
            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT)

            //set layout parameters to the view
            view.layoutParams = layoutParams

            container.addView(view) //display the inflated view

            //inflated layout components
            viewButton = findViewById(R.id.btnGetText)
            inflateText = findViewById(R.id.etInflateText)

            viewButton?.setOnClickListener()
            {
                val t = inflateText?.text
                text?.setText(t)

                button?.isEnabled = true

                //remove the inflated view
                container.removeView(view)
            }
        }
    }

}