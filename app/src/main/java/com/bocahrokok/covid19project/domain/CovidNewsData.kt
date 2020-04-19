package com.bocahrokok.covid19project.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CovidNewsData (
    @PrimaryKey
    @SerializedName("url")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("urlToImage")
    val urlToImage: String
    )

//370cad026b7e4020b2c066d775d1c68b
//https://newsapi.org/v2/top-headlines?country=us&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b
//https://newsapi.org/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b