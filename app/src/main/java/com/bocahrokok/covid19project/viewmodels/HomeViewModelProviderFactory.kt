package com.bocahrokok.covid19project.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bocahrokok.covid19project.network.CovidCityNetwork
import com.bocahrokok.covid19project.repository.CovidCitiesRepository

class HomeViewModelProviderFactory(val repository: CovidCitiesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }


}