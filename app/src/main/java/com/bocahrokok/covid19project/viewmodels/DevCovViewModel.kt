package com.bocahrokok.covid19project.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DevCovViewModel(application: Application): AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError : LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkError = MutableLiveData<Boolean>(false)
     val  isNetworkError: LiveData<Boolean>
        get() = _isNetworkError

    private val covidRepository =


}