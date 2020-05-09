package com.bocahrokok.covid19project.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.bocahrokok.covid19project.domain.CovidCountryData
import com.bocahrokok.covid19project.domain.CovidDaily


@Dao
interface CovidCityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(covidcities: List<CovidCountryData>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCovidDaily(covidDaily: List<CovidDaily>)

    @Query("select * from coviddaily ")
    fun getCovidDaily(): LiveData<List<CovidDaily>>

    @Query("select * from countryData")
    fun getCovidCities(): LiveData<List<CovidCountryData>>






}
















