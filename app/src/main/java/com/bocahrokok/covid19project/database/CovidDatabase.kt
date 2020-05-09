package com.bocahrokok.covid19project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bocahrokok.covid19project.domain.CovidCountryData
import com.bocahrokok.covid19project.domain.CovidDaily

@Database(entities = [CovidCountryData::class, CovidDaily::class], version = 1)
abstract class CovidDatabase: RoomDatabase() {

    abstract fun getCovidDataDao(): CovidCityDao

    companion object{
        @Volatile
        private var instance: CovidDatabase? = null
        private val LOCK = Any()

        operator  fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?: createDatabase(context).also{ instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CovidDatabase::class.java,
                "covidData_db.db"
            ).build()
    }
}