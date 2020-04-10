package com.bocahrokok.covid19project.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.bocahrokok.covid19project.database.getDatabase

import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.network.NetworkCovidData

import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException


class DevCovViewModel(application: Application): AndroidViewModel(application) {


    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private var _eventNetworkError = MutableLiveData<Boolean>()
    val eventNetworkError : LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkError = MutableLiveData<Boolean>()
    val  isNetworkError: LiveData<Boolean>
        get() = _isNetworkError

    private  var covidRepository = CovidCitiesRepository( CovidCityNetwork, getDatabase(application))
    val list = covidRepository.data
    val listDaily = covidRepository.dataDaily



    init {
        refresDataFromRepository()
    }

    fun refresDataFromRepository(){
        viewModelScope.launch {
            try {
                covidRepository.fetchDataInsertRoom()
                _isNetworkError.value = false
                _eventNetworkError.value = false
            } catch (networkError: IOException){
                if(list.value.isNullOrEmpty()){
                    _eventNetworkError.value = true
                }
            }
        }
    }


    val data : LiveData<List<NetworkCovidData>> = liveData(Dispatchers.IO) {
        val retrievedData = covidRepository.fetchDatafromInternet()
        emit(retrievedData)
    }



//
//    fun onNetworkErrorShown(){
//        _isNetworkError.value = true
//    }

    override fun onCleared() {
        super.onCleared()
        SupervisorJob().cancel()
    }

//    class Factory(val app: Application): ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            if(modelClass.isAssignableFrom(DevCovViewModel::class.java)) {
//                @Suppress("UNCHECKED_CAST")
//                return DevCovViewModel as T
//            }
//            throw IllegalArgumentException("Unable to construct viewModel")
//        }
//
//
//    }


}