package com.example.timewise

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.timewise.databinding.ActivityCreateSubtasksScreenBinding

@Suppress("DEPRECATION")
class CreateSubtasksScreen : AppCompatActivity()
{
    var btnCamera: Button ?= null
    var ivImage: ImageView ?= null

    //Need this for the camera intent
    companion object
    {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCreateSubtasksScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnCamera = findViewById(R.id.btnTakePicture)
        ivImage = findViewById(R.id.imageViewSubTasks)

        btnCamera?.setOnClickListener()
        {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
            {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }
            else
            {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == CAMERA_PERMISSION_CODE)
        {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }
            else
            {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT). show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK)
        {
            if(requestCode == CAMERA_REQUEST_CODE)
            {
                val thumbNail : Bitmap = data!!.extras!!.get("data") as Bitmap
                ivImage?.setImageBitmap(thumbNail)
            }
        }
    }
}