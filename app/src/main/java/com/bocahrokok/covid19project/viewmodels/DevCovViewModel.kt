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


    //repository;
    private  var covidRepository = CovidCitiesRepository( CovidCityNetwork, getDatabase(application))

    //network covid data;
    val list = covidRepository.data

    //daily list update;
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





    override fun onCleared() {
        super.onCleared()
        SupervisorJob().cancel()
    }


}