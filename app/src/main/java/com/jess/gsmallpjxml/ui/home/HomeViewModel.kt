package com.jess.gsmallpjxml.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jess.gsmallpjxml.domain.usecases.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getAllUseCase: GetAllUseCase):ViewModel() {
    fun getAll(){
       viewModelScope.launch {
        val a = withContext(Dispatchers.IO){getAllUseCase()}
           Log.d("TAG", "getAll: ${a[0]}")
       }
    }
}