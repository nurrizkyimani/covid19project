package com.bocahrokok.covid19project.domain


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bocahrokok.covid19project.domain.News.Article

@Entity(tableName = "news_response")
data class NewsResponse(
    val articles: List<Article>,
    @PrimaryKey
    val status: String,
    val totalResults: Int
)