package com.example.timewise

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity()
{
    private lateinit var firebaseAuth: FirebaseAuth
    //test for git
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //variables for the text fields
        val email = findViewById<EditText>(R.id.editTextTextUsername)
        val password = findViewById<EditText>(R.id.editTextTextPassword)

        //onclick listener for the sign in button
        binding.btnSignIn.setOnClickListener()
        {//doesn't let users log in without filling in the required fields
            if (email.text.isNullOrBlank()&&password.text.isNullOrBlank())
            {
                Toast.makeText(this, "Please fill in your details before continuing", Toast.LENGTH_SHORT).show()

            }
            else
            {
                val message: String = binding.editTextTextUsername.text.toString() + " Is Logged In"

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

                var etEmail = email?.text.toString().trim()
                var etPassword = password?.text.toString().trim()

                firebaseAuth.signInWithEmailAndPassword(etEmail, etPassword).addOnCompleteListener(){
                    if(it.isSuccessful)
                    {
                        var sendIntent = Intent(this, HomeScreen :: class.java)

                        //takes users tot he SignUp Screen
                        startActivity(sendIntent)
                    }
                    else
                    {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }

            }



        }

        binding.txtSignup.setOnClickListener()
        {
            var sendIntent = Intent(this, SignUpScreen :: class.java)
            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }




    }

}