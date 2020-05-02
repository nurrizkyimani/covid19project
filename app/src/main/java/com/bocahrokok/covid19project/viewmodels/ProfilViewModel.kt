package com.bocahrokok.covid19project.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bocahrokok.covid19project.domain.GridInfo
import com.bocahrokok.covid19project.repository.CovidCitiesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

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