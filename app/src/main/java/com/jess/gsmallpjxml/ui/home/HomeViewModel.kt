package com.jess.gsmallpjxml.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _livedata = MutableLiveData<String>("Hola Mundo")
    val livedata: LiveData<String> = _livedata

    private var _stateFlow = MutableStateFlow<String>("Prueba")
    val stateFlow: StateFlow<String> = _stateFlow

    private var _sharedFlow = MutableStateFlow<String>("Prueba")
    val sharedFlow: StateFlow<String> = _sharedFlow

    fun triggerLiveData() {
        _livedata.value = "LiveData"
        println("from vm livedata")
    }

    fun triggerFlow(): Flow<String> {
        return flow<String> {
            repeat(5) {
                delay(1000)
                emit(" value $it")
                println("values $it")
            }
            println("from vm Flow")
        }
    }

    fun triggerStateFlow() {
        _stateFlow.value = "StateFlow"
        println("from vm stateFlow")
    }

    fun triggerSharedFlow() {
        viewModelScope.launch() {
            _sharedFlow.emit("SharedFlow")
            println("from vm SharedFlow")
        }
    }
}