package com.bocahrokok.covid19project.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CovidCityDao {

    @Query("select * from databasecovidcountry")
    fun getCovidCities(): LiveData< List<DatabaseCovidCountry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(covidcities: List<DatabaseCovidCountry>)

    @Database(entities = [DatabaseCovidCountry::class], version = 1)


    abstract class CovidCityDatabase: RoomDatabase() {
        abstract val CovidCityDao: CovidCityDao
    }

}


private lateinit var INSTANCE : CovidCityDao.CovidCityDatabase

fun getDatabase(context: Context): CovidCityDao.CovidCityDatabase {

    synchronized(CovidCityDao.CovidCityDatabase::class.java){
        INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CovidCityDao.CovidCityDatabase::class.java,
                    "covidcity").build()
    }

    return INSTANCE
}

