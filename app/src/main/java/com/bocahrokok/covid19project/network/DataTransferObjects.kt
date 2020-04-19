package com.bocahrokok.covid19project.network

import android.provider.ContactsContract
import com.bocahrokok.covid19project.database.DatabaseCovidCountry
import com.google.gson.annotations.SerializedName

data class NetworkCovidData(

    @SerializedName("countryRegion")
    val countryRegion: String,
    @SerializedName("confirmed")
    val confirmed: Int? = 0,
    @SerializedName("recovered")
    val recovered: Int? = 0,
    @SerializedName("deaths")
    val deaths: Int? = 0,
    @SerializedName("active")
    val active: Int? = 0,
    @SerializedName("lastUpdate")
    val lastUpdate: Long? = 0,
    @SerializedName("iso2")
    val iso3: String?

)



fun List<NetworkCovidData>.asDatabaseModel(): List<DatabaseCovidCountry>{
    return map {
        DatabaseCovidCountry(
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

