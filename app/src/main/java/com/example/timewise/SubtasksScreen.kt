package com.example.timewise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivitySubtasksScreenBinding

class SubtasksScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivitySubtasksScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddSubTask.setOnClickListener()
        {

            var sendIntent = Intent(this, CreateSubtasksScreen :: class.java)

            //takes users tot he SignUp Screen
            startActivity(sendIntent)

        }

    }


}