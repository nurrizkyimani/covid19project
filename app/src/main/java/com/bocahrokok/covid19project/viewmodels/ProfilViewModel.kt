package com.bocahrokok.covid19project.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bocahrokok.covid19project.domain.News.GridInfo
import com.bocahrokok.covid19project.repository.CovidCitiesRepository

class ProfilViewModel(val repository: CovidCitiesRepository) : ViewModel() {

        init {
//            gridList()
        }

         val gridListLiveData : MutableLiveData<List<GridInfo>> = MutableLiveData()

//        fun gridList(){
//            val gridList = repository.setGridInList()
//            gridListLiveData.postValue(gridList)
//
//        }

}