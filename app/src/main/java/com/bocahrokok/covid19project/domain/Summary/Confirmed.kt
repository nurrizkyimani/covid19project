package com.bocahrokok.covid19project.domain.Summary


import com.google.gson.annotations.SerializedName

data class Confirmed(
    val detail: String,
    val value: Int
)