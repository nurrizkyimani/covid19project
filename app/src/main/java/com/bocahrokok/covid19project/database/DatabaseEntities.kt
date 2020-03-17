package com.bocahrokok.covid19project.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bocahrokok.covid19project.domain.CovidCountryData

@Entity
data class DatabaseCovidCountry constructor(
    @PrimaryKey
    val iso3: String,
    val countryRegion: String,
    val confirmed: Int,
    val recovered: Int,
    val deaths: Int,
    val active: Int,
    val lastUpdate: Long
)

fun List<DatabaseCovidCountry>.asDomainModel(): List<CovidCountryData> {
    return map {
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