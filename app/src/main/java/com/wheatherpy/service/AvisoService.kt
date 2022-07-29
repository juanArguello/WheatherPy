package com.wheatherpy.service

import com.wheatherpy.entities.AvisoMeteorologico
import retrofit2.Call
import retrofit2.http.GET

interface AvisoService {
    @GET("admin-ajax.php?action=dmh_avisos")
    fun getAviso(): Call<AvisoMeteorologico>
}