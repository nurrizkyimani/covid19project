package com.bocahrokok.covid19project.database

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.bocahrokok.covid19project.network.NetworkCovidData

@Entity
data class DatabaseCovidCountry (
    @PrimaryKey
    val countryRegion: String,
    val confirmed: Int? = 0,
    val recovered: Int? = 0,
    val deaths: Int? = 0,
    val active: Int? = 0,
    val lastUpdate: Long? = 0,
    val iso3: String?

)

fun List<DatabaseCovidCountry>.asDomainModel(): List<NetworkCovidData> {
    return map {
        NetworkCovidData(
            countryRegion= it.countryRegion,
            confirmed= it.confirmed,
            recovered= it.recovered,
            deaths= it.deaths,
            active= it.active,
            lastUpdate= it.lastUpdate,
            iso3 = it.iso3
        )
    }
}
