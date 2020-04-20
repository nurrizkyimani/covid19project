package com.bocahrokok.covid19project.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bocahrokok.covid19project.domain.CovidNewsData
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(val repository: CovidCitiesRepository): ViewModel() {

    val newsList: MutableLiveData<List<CovidNewsData>> = MutableLiveData()

    init {
        getNewsFromRepository()
    }

    fun getNewsFromRepository() = viewModelScope.launch{
        val response = repository.fetchNewsFromApi()
        newsList.postValue(response)
        Timber.d("FETCH GET NEWS")
    }
}