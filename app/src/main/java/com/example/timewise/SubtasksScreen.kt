package com.example.timewise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timewise.databinding.ActivitySignUpScreenBinding

class SubtasksScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAddSubTask = null
        btnAddSubTask.setOnClickListener()
        {


        }
    }


}