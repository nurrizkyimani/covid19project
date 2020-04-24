package com.bocahrokok.covid19project.network

import com.bocahrokok.covid19project.domain.CovidNewsData
import com.bocahrokok.covid19project.domain.NewsResponse
import com.bocahrokok.covid19project.util.Constant
import com.bocahrokok.covid19project.util.Constant.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b")
    suspend fun getNews(): List<CovidNewsData>

    @GET("/v2/everything")
    suspend fun getEverythingNews(
        @Query("language")
        language: String = "en",
        @Query("q")
        q: String = "covid",
        @Query("apiKey")
        apiKey: String = API_KEY
    ): Response<NewsResponse>
}

//https://newsapi.org/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b