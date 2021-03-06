package com.bocahrokok.covid19project.network


import com.bocahrokok.covid19project.domain.CovidCountryData
import com.bocahrokok.covid19project.domain.CovidDaily
import com.bocahrokok.covid19project.domain.Summary.CovidIndonesiaSum
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CovidService {

    @GET("api/confirmed")
    suspend fun getCovidCountriesData(): List<CovidCountryData>

    @GET("/api/daily")
    suspend fun getCovidDailyData(): List<CovidDaily>

    @GET("/api/countries/Indonesia")
    suspend fun getCovidIndonesiaSum(): Response<CovidIndonesiaSum>
}


object CovidCityNetwork {
     val retrofit = Retrofit.Builder()
        .baseUrl("https://covid19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val covidcities = retrofit.create(CovidService::class.java)

}