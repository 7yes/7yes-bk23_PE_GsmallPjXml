package com.jess.gsmallpjxml.data.model

import com.google.gson.annotations.SerializedName

data class MyResponseItem(
   @SerializedName("description") val description: String,
   @SerializedName("ingredients") val ingredients: List<String>,
   @SerializedName("location") val location: Location,
   @SerializedName("name") val name: String,
   @SerializedName("photo") val photo: String
)