package com.wheatherpy.entities

import com.google.gson.annotations.SerializedName

data class Weather(
    val id: Int,
    @SerializedName("main") val principal: String,
    @SerializedName("description") val descripcion: String,
    val icon: String
)
