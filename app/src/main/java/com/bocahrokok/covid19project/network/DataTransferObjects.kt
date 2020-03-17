package com.bocahrokok.covid19project.network

import com.bocahrokok.covid19project.domain.CovidCountryData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCovidDataContainer(val countriesData: List<NetworkCovidData>)


@JsonClass(generateAdapter = true)
data class NetworkCovidData(
    val countryRegion: String,
    val confirmed: Int,
    val recovered: Int,
    val deaths: Int,
    val active: Int,
    val lastUpdate: Long,
    val iso3: String
)

fun NetworkCovidDataContainer.asDomainModel(): List<CovidCountryData> {
    return countriesData.map {
        CovidCountryData(
            iso3 = it.iso3,
            countryRegion= it.countryRegion,
            confirmed= it.confirmed,
            recovered= it.recovered,
            deaths= it.deaths,
            active= it.active,
            lastUpdate= it.lastUpdate

        )
    }
}