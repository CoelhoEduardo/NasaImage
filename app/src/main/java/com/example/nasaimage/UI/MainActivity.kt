package com.example.nasaimage.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.nasaimage.R
import com.example.nasaimage.ViewModel.ApodViewModel
import com.example.nasaimage.utils.load

class MainActivity : AppCompatActivity() {

    private val apodViewModel: ApodViewModel by viewModels()
    private val loading: FrameLayout
        get() = findViewById(R.id.loading)
    private val image: ImageView
        get() = findViewById(R.id.image)
    private val date: TextView
        get() = findViewById(R.id.date)
    private val explanation: TextView
        get() = findViewById(R.id.explanation)
    private val title: TextView
        get() = findViewById(R.id.title)
    private val copyright: TextView
        get() = findViewById(R.id.copyright)
    private val backArrow: ImageButton
        get() = findViewById(R.id.back_home)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backArrow.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        apodViewModel.loadApod()

        observeApod()


    }

    fun observeApod(){
        apodViewModel.loading.observe(this) {loading.isVisible = it }
        apodViewModel.error.observe(this){
            if (it)
                Toast.makeText(this, "Não foi possivel carregar imagem", Toast.LENGTH_LONG).show()
        }
        apodViewModel.apod.observe(this){

            image.load(it.url)
            date.setText("Date: ${it.date} ")
            explanation.setText(it.explanation)
            title.setText(it.title)
            copyright.setText("Copyright: ${it.copyright}")

            Toast.makeText(this, "Imagem vindo da nasa com sucesso", Toast.LENGTH_LONG).show()

        }
    }
}


