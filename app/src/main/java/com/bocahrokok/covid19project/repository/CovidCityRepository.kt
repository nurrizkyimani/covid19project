package com.bocahrokok.covid19project.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import com.bocahrokok.covid19project.database.*
import com.bocahrokok.covid19project.domain.CovidDaily
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.network.NetworkCovidData
import com.bocahrokok.covid19project.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber


class CovidCitiesRepository ( private val service : CovidCityNetwork, private val database: CovidCityDao.CovidCityDatabase ) {



    suspend fun fetchDatafromInternet(): List<NetworkCovidData>{
        return service.covidcities.getCovidCountriesData()
    }

    suspend fun fetchDataInsertRoom() {
        withContext(Dispatchers.IO){
            Timber.d("refresh video into room")
            val listNetworkCovidData = service.covidcities.getCovidCountriesData()
            database.covidCityDao.insertAll(listNetworkCovidData.asDatabaseModel())

            val listCovidDaily = service.covidcities.getCovidDailyData()
            database.covidCityDao.insertCovidDaily(listCovidDaily)

        }
    }

    val data : LiveData<List<NetworkCovidData>> = Transformations.map(database.covidCityDao.getCovidCities()){
        it.asDomainModel()
        }

    val dataDaily: LiveData<List<CovidDaily>> = database.covidCityDao.getCovidDaily()

}



