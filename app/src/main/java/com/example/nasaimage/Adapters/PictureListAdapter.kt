package com.example.nasaimage.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaimage.R
import com.example.nasaimage.ViewHolders.PictureListViewHolder
import com.example.nasaimage.data.model.ApodData

class PictureListAdapter : RecyclerView.Adapter<PictureListViewHolder>() {
    private val apod: MutableList<ApodData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PictureListViewHolder(layoutInflater.inflate(R.layout.item_picture, parent, false))
    }

    override fun onBindViewHolder(holder: PictureListViewHolder, position: Int) {
        holder.bind(apod[position])
    }

    override fun getItemCount() = apod.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newItems: List<ApodData>){
        apod.addAll(newItems)
        notifyDataSetChanged()
    }

}