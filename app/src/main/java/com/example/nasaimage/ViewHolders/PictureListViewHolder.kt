package com.example.nasaimage.ViewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaimage.R
import com.example.nasaimage.data.model.ApodData
import com.example.nasaimage.utils.load

class PictureListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val url = view.findViewById<ImageView>(R.id.picture_item)
    val title = view.findViewById<TextView>(R.id.item_title)
    val date = view.findViewById<TextView>(R.id.item_date)
    val explanation = view.findViewById<TextView>(R.id.item_explanation)

    fun bind(apod: ApodData){
        title.text = apod.title
        date.text = apod.date
        url.load(apod.url)
        explanation.text = apod.explanation
    }
}