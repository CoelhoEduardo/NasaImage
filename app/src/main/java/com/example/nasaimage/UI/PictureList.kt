package com.example.nasaimage.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaimage.Adapters.PictureListAdapter
import com.example.nasaimage.R
import com.example.nasaimage.ViewModel.PicturesViewModel

class PictureList : AppCompatActivity() {

    private val picturesViewModel: PicturesViewModel by viewModels()

    private val loadingPictures: FrameLayout
        get() = findViewById(R.id.loading_pictures)
    private val adapter = PictureListAdapter()

    private val recycler: RecyclerView
        get() = findViewById(R.id.recycler_pictures)

    private val backHome: ImageButton
        get() = findViewById(R.id.back_home_list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_list)

        backHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        recycler.adapter = adapter

        picturesViewModel.loadPictures()

        observePictureList()
    }

    fun observePictureList(){
        picturesViewModel.loading.observe(this) {loadingPictures.isVisible = it}
        picturesViewModel.error.observe(this) {
            if (it)
                Toast.makeText(this, "Não carregou a lista", Toast.LENGTH_SHORT).show()
        }
        picturesViewModel.apod.observe(this) {
            adapter.updateList(it.apod)
        }
    }
}
