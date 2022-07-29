package com.wheatherpy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.wheatherpy.entities.OpenWeatherDatos
import com.wheatherpy.service.OpenWeatherMapService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimaCityActivity : AppCompatActivity() {

    private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private lateinit var ciudad: String
    private val TAG: String = ".ClimaCityActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima_city)
        ciudad = intent.getStringExtra("ciudadElegida").toString()
        var update_at = findViewById<TextView>(R.id.update_at)
        update_at.text = ciudad
        val retrofit = getRetrofit()
        val service = retrofit.create(OpenWeatherMapService::class.java)
        //getInforme(service)



    }

    private fun getInforme(service: OpenWeatherMapService) {
        service.getClimaByCiudad(ciudad).enqueue(object: Callback<OpenWeatherDatos> {
            override fun onResponse(call: Call<OpenWeatherDatos>, response: Response<OpenWeatherDatos>) {
                //val climaByCity = response.body()
                //println(climaByCity.toString())
            }
            override fun onFailure(call: Call<OpenWeatherDatos>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}