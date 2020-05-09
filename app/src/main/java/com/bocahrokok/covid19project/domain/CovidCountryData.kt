package com.bocahrokok.covid19project.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "countryData")
data class CovidCountryData(
    @PrimaryKey()
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
    val lastUpdate: Long = 0)