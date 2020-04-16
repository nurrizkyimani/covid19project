package com.bocahrokok.covid19project.network


import com.bocahrokok.covid19project.domain.CovidDaily
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CovidService {

    @GET("api/confirmed")
    suspend fun getCovidCountriesData(): List<NetworkCovidData>

    @GET("/api/daily")
    suspend fun getCovidDailyData(): List<CovidDaily>
}


object CovidCityNetwork {
     val retrofit = Retrofit.Builder()
        .baseUrl("https://covid19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val covidcities = retrofit.create(CovidService::class.java)

}