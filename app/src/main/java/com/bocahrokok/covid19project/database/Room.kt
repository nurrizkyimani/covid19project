package com.bocahrokok.covid19project.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.bocahrokok.covid19project.domain.CovidDaily


@Dao
interface CovidCityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(covidcities: List<DatabaseCovidCountry>)

    @Query("select * from databasecovidcountry")
    fun getCovidCities(): LiveData<List<DatabaseCovidCountry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCovidDaily(covidDaily: List<CovidDaily>)

    @Query("select * from coviddaily ")
    fun getCovidDaily(): LiveData<List<CovidDaily>>


    @Database(entities = [DatabaseCovidCountry::class, CovidDaily::class], version = 1)
    abstract class CovidCityDatabase : RoomDatabase() {
        abstract val covidCityDao: CovidCityDao
    }

//    @Database(entities = [CovidDaily::class], version = 1)



}


private lateinit var instance : CovidCityDao.CovidCityDatabase

fun getDatabase(context: Context): CovidCityDao.CovidCityDatabase{
    synchronized(CovidCityDao.CovidCityDatabase::class.java){
        instance = Room.databaseBuilder(
            context.applicationContext,
            CovidCityDao.CovidCityDatabase::class.java,
            "covidDaoBuild").build()
    }

    return instance

}





//    companion object {
//
//        private var instance : CovidCityDatabase? = null
//
//        fun getInstance(context: Context): CovidCityDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context).also { instance = it }
//            }
//        }
//
//        fun buildDatabase(context: Context): CovidCityDatabase{
//            synchronized(CovidCityDatabase::class.java){
//                return Room.databaseBuilder(
//                    context.applicationContext,
//                    CovidCityDatabase::class.java, "covidDaoBuild").build()
//            }
//
//        }
//
//    }
//}




//object halo {
//
//
//    fun getInstance(context: Context): CovidCityDatabase {
//        return instance ?: synchronized(this) {
//            instance ?: buildDatabase(context).also { instance = it }
//        }
//    }
//
//
//}







