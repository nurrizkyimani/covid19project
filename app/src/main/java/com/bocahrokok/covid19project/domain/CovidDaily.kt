package com.bocahrokok.covid19project.domain

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CovidDaily(
    @PrimaryKey
    @SerializedName("reportDate")
    val reportDate: String,
    @SerializedName("totalConfirmed")
    val totalConfirmed: Int?= 0,
    @SerializedName("deltaConfirmed")
    val deltaConfirmed: Int?=0,
    @SerializedName("mainlandChina")
    val mainlandChina: Int?= 0,
    @SerializedName("otherLocations")
    val otherLocations: Int?=0
    )