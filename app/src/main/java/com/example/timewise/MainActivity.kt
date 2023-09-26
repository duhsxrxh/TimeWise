package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    //test for git
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
            var sendIntent = Intent(this, SignUpScreen :: class.java)
            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }

        /*val profileButton = findViewById<Button>(R.id.btnProfileScreen)
        profileButton.setOnClickListener(View.OnClickListener
        {
            val profileIntent = Intent(this, ProfileScreen::class.java)
            startActivity(profileIntent)
        })*/


    }

}