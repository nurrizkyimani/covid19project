package com.bocahrokok.covid19project.domain.Summary


import com.google.gson.annotations.SerializedName

data class Deaths(
    val detail: String,
    val value: Int
)