package com.bocahrokok.covid19project.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bocahrokok.covid19project.repository.CovidCitiesRepository

class ListViewModelProviderFactory(val repository: CovidCitiesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}