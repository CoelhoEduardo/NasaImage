package com.example.nasaimage.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String){
    Glide.with(this.context).load(url).centerCrop().into(this)
}
