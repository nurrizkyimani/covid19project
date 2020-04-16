package com.bocahrokok.covid19project.domain

data class NetworkCovidData (val countryRegion: String,
                        val confirmed: Int? = 0,
                        val recovered: Int? = 0,
                        val deaths: Int? = 0,
                        val active: Int? = 0,
                        val lastUpdate: Long? = 0,
                        val iso3: String?)

