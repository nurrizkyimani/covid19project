package com.bocahrokok.covid19project.network

import com.bocahrokok.covid19project.domain.CovidNewsData
import retrofit2.http.GET

interface NewsApi {
    @GET("/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b")
    suspend fun getNews(): List<CovidNewsData>
}

//https://newsapi.org/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b