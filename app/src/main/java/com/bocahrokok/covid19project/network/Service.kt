package com.bocahrokok.covid19project.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface CovidService {

    @GET("confirmed")
    fun getCovidCountriesData(): Deferred<NetworkCovidDataContainer>
}


object CovidCityNetwork {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://covid19.mathdro.id/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val covidcities = retrofit.create(CovidService::class.java)
}