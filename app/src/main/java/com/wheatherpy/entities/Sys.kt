package com.wheatherpy.entities

import com.google.gson.annotations.SerializedName

data class Sys(
    val type: Int,
    val id: Int,
    @SerializedName("country") val pais: String,
    val sunrise: Int,
    val sunset: Int
)
