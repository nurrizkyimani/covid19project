package com.bocahrokok.covid19project.domain



data class CovidCountryData (val countryRegion: String,
                   val confirmed: Int,
                   val recovered: Int,
                   val deaths: Int,
                   val active: Int,
                   val lastUpdate: Long,
                   val iso3: String ) {

    val realDate: String
        get() {
            val sdf = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date = java.util.Date(lastUpdate * 1000)
            return sdf.format(date)


        }


}