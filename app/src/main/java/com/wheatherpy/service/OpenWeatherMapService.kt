package com.wheatherpy.service

import com.wheatherpy.entities.OpenWeatherDatos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherMapService {

    @GET("weather?q={city},py&lang=es&appid=API_KEY")
    fun getClimaByCiudad(@Path("city") city:String): Call<OpenWeatherDatos>
}