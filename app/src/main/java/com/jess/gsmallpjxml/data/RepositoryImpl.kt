package com.jess.gsmallpjxml.data

import com.jess.gsmallpjxml.domain.model.MyItem
import com.jess.gsmallpjxml.domain.model.toDomain
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {
    suspend fun getMyItems(): List<MyItem> {
       val call = api.getAll()
        if (call.isSuccessful) {
           return   call.body()?.map { it.toDomain() } ?: emptyList()
        }
        return emptyList()
    }
}