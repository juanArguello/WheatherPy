package com.wheatherpy.entities

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") val temperatura: Double,
    @SerializedName("feels_like") val sensacion: Double,
    @SerializedName("temp_min") val temperatura_minima: Double,
    @SerializedName("temp_max") val temperatura_maxima: Double,
    @SerializedName("pressure") val presion: Int,
    @SerializedName("humidity") val humedad: Int
)
