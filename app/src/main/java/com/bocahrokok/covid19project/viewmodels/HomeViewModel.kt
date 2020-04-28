package com.bocahrokok.covid19project.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bocahrokok.covid19project.database.getDatabase
import com.bocahrokok.covid19project.domain.Article
import com.bocahrokok.covid19project.domain.CovidNewsData
import com.bocahrokok.covid19project.domain.NewsResponse
import com.bocahrokok.covid19project.domain.Summary.CovidIndonesiaSum
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber

class HomeViewModel(val repository: CovidCitiesRepository): ViewModel() {

    val newsList: MutableLiveData<List<CovidNewsData>> = MutableLiveData()

    val newsReponse: MutableLiveData<Response<NewsResponse>> = MutableLiveData()

    val newsResponseList: MutableLiveData<List<Article>> = MutableLiveData()

    val dailyList = repository.dataDaily

    val indoSumResponse: MutableLiveData<Response<CovidIndonesiaSum>> = MutableLiveData()




    init {
//      getNewsFromRepository()
        getNewsReponse()
        covidIndoSumViewModel()

    }


    private fun covidIndoSumViewModel() = viewModelScope.launch {
        val response = repository.CovidIndoSum()
        indoSumResponse.postValue(response)
    }




    fun getNewsReponse() = viewModelScope.launch {
        val response = repository.fetchNewsResponse()
        newsReponse.postValue(response)
        val list = response.body()!!.articles
        newsResponseList.postValue(list)
    }

    fun getNewsFromRepository() = viewModelScope.launch{
        val response = repository.fetchNewsFromApi()
        newsList.postValue(response)
        Timber.d("FETCH GET NEWS")
    }
}