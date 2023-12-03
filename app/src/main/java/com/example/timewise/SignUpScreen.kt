package com.example.timewise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.timewise.databinding.ActivitySignUpScreenBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpScreen : AppCompatActivity()
{
    var etUsername : EditText ?= null
    var etEmail : EditText ?= null
    var etPassword : EditText ?= null
    var btnSignUp : Button ?= null



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etUsername = findViewById(R.id.txtCreateUsername)
        etEmail = findViewById(R.id.txtCreateEmail)
        etPassword = findViewById(R.id.txtCreatePassword)
        btnSignUp = findViewById(R.id.btnSignUp)

        val username = findViewById<EditText>(R.id.txtCreateUsername)
        val password = findViewById<EditText>(R.id.txtCreatePassword)
        val email = findViewById<EditText>(R.id.txtCreateEmail)

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("User Details")
        val newUserRef = myRef.push()

        binding.btnBack.setOnClickListener()
        {
            var sendIntent = Intent(this, MainActivity :: class.java)

            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }

        binding.btnSignUp.setOnClickListener()
        {

            //myRef.push().setValue("Hello")



            if (username.text.isNullOrBlank() && password.text.isNullOrBlank() && email.text.isNullOrBlank())
            {
                Toast.makeText(this, "Please fill in your details before continuing", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val message: String = binding.txtCreateUsername.text.toString() + "'s Account Created"

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                var sendIntent = Intent(this, HomeScreen :: class.java)

                //takes users tot he SignUp Screen
                startActivity(sendIntent)
            }

            var username = etUsername?.text.toString().trim()
            //myRef.push().setValue(user)
            newUserRef.child("Username").setValue(username)

            var email = etEmail?.text.toString().trim()
            newUserRef.child("Email").setValue(email)

            var password = etPassword?.text.toString().trim()
            newUserRef.child("Password").setValue(password)

        }





    }


}