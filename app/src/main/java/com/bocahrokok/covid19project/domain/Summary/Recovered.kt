package com.bocahrokok.covid19project.domain.Summary


import com.google.gson.annotations.SerializedName

data class Recovered(
    val detail: String,
    val value: Int
)