package com.jess.gsmallpjxml.data

import com.jess.gsmallpjxml.data.model.MyResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("recetas")
    suspend fun getAll(): Response<MyResponse>

//    @GET("search")
//    suspend fun getAll(@Query("query") query:String): Response<LongResponse>

//    @GET("random")
//    suspend fun getRandom(): Response<JokeModelSimpleResponse>
//
//    @GET("random")
//    suspend fun getCustom(@Query("name") name:String):Response<JokeModelSimpleResponse>
//
//    @GET("/{sign}")
//    suspend fun getHoroscope(@Path("sign") sign :String):PredictionResponse

}