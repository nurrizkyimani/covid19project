package com.bocahrokok.covid19project.network

import retrofit2.http.GET

interface NewsApi {
    @GET("everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b")
    suspend fun

}

//https://newsapi.org/v2/everything?language=en&q=covid&apiKey=370cad026b7e4020b2c066d775d1c68b