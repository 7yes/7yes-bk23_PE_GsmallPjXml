package com.jess.gsmallpjxml.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jess.gsmallpjxml.domain.model.MyItem
import com.jess.gsmallpjxml.domain.usecases.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {
    private val _lista  = MutableLiveData<List<MyItem>>()
    val lista: LiveData<List<MyItem>> = _lista
    fun getAll(){
       viewModelScope.launch {
           val answer = withContext(Dispatchers.IO){getAllUseCase()}
           _lista.value = answer
       }
    }
}