package com.bocahrokok.covid19project.domain


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)