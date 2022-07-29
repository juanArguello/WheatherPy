package com.wheatherpy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.wheatherpy.entities.AvisoMeteorologico
import com.wheatherpy.service.AvisoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://www.meteorologia.gov.py/wp-admin/"
    private val TAG: String = ".MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = getRetrofit()
        val service = retrofit.create(AvisoService::class.java)
        getAviso(service)

        // acceder a los elementos de la lista
        val ciudadesArray = resources.getStringArray(R.array.ciudades_array)

        val adapter = ArrayAdapter(this, R.layout.dropdown_item, ciudadesArray)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(adapter)
        
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this,ClimaCityActivity::class.java)
            intent.putExtra("ciudadElegida",ciudadesArray[position])
            startActivity(intent)
        }

    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun getAviso(service: AvisoService) {
        service.getAviso().enqueue(object: Callback<AvisoMeteorologico> {
            override fun onResponse(call: Call<AvisoMeteorologico>, response: Response<AvisoMeteorologico>) {
                val aviso = response.body()
                Log.d(TAG, aviso!!.data.descripcion)
                Log.d(TAG, aviso!!.data.fecha)
                Log.d(TAG, aviso!!.data.hora_local)
                visualizarAviso(aviso)
            }
            override fun onFailure(call: Call<AvisoMeteorologico>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun visualizarAviso(aviso: AvisoMeteorologico) {
        val listView = findViewById<ListView>(R.id.view_aviso)

        if(aviso.data.importante){

        }else{
            val arreglo = arrayOf(aviso.data.descripcion, "Fecha: ${aviso.data.fecha} ${aviso.data.hora_local}")
            val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, arreglo)
            listView.adapter = arrayAdapter
        }
    }

}



