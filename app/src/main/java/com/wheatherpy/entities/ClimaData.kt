package com.wheatherpy.entities

import com.google.gson.annotations.SerializedName

data class ClimaData(
    @SerializedName("coord") val coordenada: Coord,
    @SerializedName("weather") val clima: List<Weather>,
    val base: String,
    @SerializedName("main") val principal: Main,
    @SerializedName("visibility") val visibilidad: Int,
    val wind: Wind,
    @SerializedName("clouds") val nubes: Clouds,
    val dt: Int,
    val sys: Sys,
    val timezone: Int,
    var id: Int,
    @SerializedName("name")var ciudad:String,
    @SerializedName("cod") val codigo: Int
)