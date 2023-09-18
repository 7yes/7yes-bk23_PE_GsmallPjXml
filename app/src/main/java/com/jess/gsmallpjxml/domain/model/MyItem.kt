package com.jess.gsmallpjxml.domain.model

import com.jess.gsmallpjxml.data.model.Location
import com.jess.gsmallpjxml.data.model.MyResponseItem

data class MyItem(
    val description: String,
    val location: Location,
    val name: String,
    val photo: String
)

fun MyResponseItem.toDomain() = MyItem(description, location, name, photo)