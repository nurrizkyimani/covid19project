package com.bocahrokok.covid19project.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.bocahrokok.covid19project.R
import com.bocahrokok.covid19project.database.*
import com.bocahrokok.covid19project.domain.CovidCountryData
import com.bocahrokok.covid19project.domain.CovidDaily
import com.bocahrokok.covid19project.domain.CovidNewsData
import com.bocahrokok.covid19project.domain.GridInfo
import com.bocahrokok.covid19project.network.CovidCityNetwork

import com.bocahrokok.covid19project.network.NewsInstance

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber


class CovidCitiesRepository ( private val service : CovidCityNetwork, val db: CovidDatabase ) {


    suspend fun fetchDatafromInternet(): List<CovidCountryData>{
        return service.covidcities.getCovidCountriesData()
    }

    suspend fun fetchNewsFromApi(): List<CovidNewsData>{
        return NewsInstance.instance.getNews()
        Timber.d("whipeIt")
    }

    suspend fun fetchNewsResponse() = NewsInstance.instanceNewsReponse.getEverythingNews()

    suspend fun CovidIndoSum() = service.covidcities.getCovidIndonesiaSum()


    suspend fun fetchDataInsertRoom() {
        withContext(Dispatchers.IO){
            Timber.d("refresh video into room")
            val listNetworkCovidData = service.covidcities.getCovidCountriesData()
            db.getCovidDataDao().insertAll(listNetworkCovidData)
            val listCovidDaily = service.covidcities.getCovidDailyData()
            db.getCovidDataDao().insertCovidDaily(listCovidDaily)

        }
    }


    val data : LiveData<List<CovidCountryData>> = db.getCovidDataDao().getCovidCities()

    val dataDaily: LiveData<List<CovidDaily>> = db.getCovidDataDao().getCovidDaily()

}



