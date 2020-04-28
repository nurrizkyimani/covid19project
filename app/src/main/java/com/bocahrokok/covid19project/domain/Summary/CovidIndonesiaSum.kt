package com.bocahrokok.covid19project.domain.Summary


data class CovidIndonesiaSum(
    val confirmed: Confirmed,
    val deaths: Deaths,
    val lastUpdate: String,
    val recovered: Recovered
)