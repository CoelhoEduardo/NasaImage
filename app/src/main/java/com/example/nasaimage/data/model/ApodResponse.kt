package com.example.nasaimage.data.model


data class ApodResponse(val apod: List<ApodData>)
data class ApodData(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val title: String,
    val url: String,
)
