package com.bocahrokok.covid19project.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bocahrokok.covid19project.domain.CovidNewsData
import com.bocahrokok.covid19project.domain.NewsResponse
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber

class HomeViewModel(val repository: CovidCitiesRepository): ViewModel() {

    val newsList: MutableLiveData<List<CovidNewsData>> = MutableLiveData()

    val newsReponse: MutableLiveData<Response<NewsResponse>> = MutableLiveData()



    init {
//        getNewsFromRepository()
        getNewsReponse()
    }

    fun getNewsReponse() = viewModelScope.launch {
        val response = repository.fetchNewsResponse()
        newsReponse.postValue(response)
    }

    fun getNewsFromRepository() = viewModelScope.launch{
        val response = repository.fetchNewsFromApi()
        newsList.postValue(response)
        Timber.d("FETCH GET NEWS")
    }
}