package com.bocahrokok.covid19project.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object Utils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatTime( time: Long): String {
        val instant = Instant.ofEpochMilli(time)
        val local = instant.atZone(ZoneId.systemDefault()).toLocalDateTime()
        return local.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
    }
}