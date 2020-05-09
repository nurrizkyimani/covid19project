package com.bocahrokok.covid19project.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.bocahrokok.covid19project.domain.CovidCountryData

import com.bocahrokok.covid19project.network.CovidCityNetwork


import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException


class ListViewModel(application: Application, val covidRepository: CovidCitiesRepository): AndroidViewModel(application) {


    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private var _eventNetworkError = MutableLiveData<Boolean>()
    val eventNetworkError : LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkError = MutableLiveData<Boolean>()
    val  isNetworkError: LiveData<Boolean>
        get() = _isNetworkError

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


    val data : LiveData<List<CovidCountryData>> = liveData(Dispatchers.IO) {
        val retrievedData = covidRepository.fetchDatafromInternet()
        emit(retrievedData)
    }





    override fun onCleared() {
        super.onCleared()
        SupervisorJob().cancel()
    }


}