package com.example.nasaimage.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.nasaimage.R

class Home : AppCompatActivity() {

    private val todayPictureBtn: Button
        get() = findViewById(R.id.picture_day)

    private val favoriteBtn: Button
        get() = findViewById(R.id.picture_favorite)

    private val pictureList: Button
        get() = findViewById(R.id.pictures_list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        favoriteBtn.setOnClickListener {
            Toast.makeText(this,"In Development", Toast.LENGTH_SHORT).show()
        }

        pictureList.setOnClickListener {
            startActivity(Intent(this, PictureList::class.java))
        }

        todayPictureBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java ))
        }
    }
}
