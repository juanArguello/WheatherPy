package com.wheatherpy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val API_KEY : String = "98b614a99c65dd704d247cb7327536fd"
    var asuncion= "https://api.openweathermap.org/data/2.5/weather?q=Asuncion,py&appid=98b614a99c65dd704d247cb7327536fd&lang=es"
    var presidente_franco = "https://api.openweathermap.org/data/2.5/weather?q=Presidente Franco,py&appid=98b614a99c65dd704d247cb7327536fd&lang=es"
    var Encarnacion = "https://api.openweathermap.org/data/2.5/weather?q=Encarnacion,py&appid=98b614a99c65dd704d247cb7327536fd&lang=es"
    var capiata = "https://api.openweathermap.org/data/2.5/weather?q=Capiata,py&appid=98b614a99c65dd704d247cb7327536fd&lang=es"
    var Villarrica = "https://api.openweathermap.org/data/2.5/weather?q=Villarrica,py&appid=98b614a99c65dd704d247cb7327536fd&lang=es"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
