package com.bocahrokok.covid19project.repository

import com.bocahrokok.covid19project.database.CovidCityDao
import com.bocahrokok.covid19project.network.CovidCityNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CovidCitiesRepository(private val database: CovidCityDao.CovidCityDatabase) {

    suspend fun refreshCovidCities(){
        withContext(Dispatchers.IO) {
            val CovidCityList = CovidCityNetwork
        }
    }
}