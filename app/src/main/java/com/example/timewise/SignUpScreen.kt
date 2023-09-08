package com.example.timewise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.timewise.databinding.ActivitySignUpScreenBinding

class SignUpScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = findViewById<EditText>(R.id.txtCreateUsername)
        val password = findViewById<EditText>(R.id.txtCreatePassword)
        val email = findViewById<EditText>(R.id.txtCreateEmail)

        binding.btnBack.setOnClickListener()
        {
            var sendIntent = Intent(this, MainActivity :: class.java)

            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }

        binding.btnSignUp.setOnClickListener()
        {
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

        }





    }


}