package com.wheatherpy.entities

data class Data(
    val importante: Boolean,
    val numero_aviso: String,
    val fenomenos_esperados: String,
    val descripcion: String,
    val zona_cobertura: String,
    val departamentos_afectados: String,
    val fecha: String,
    val hora_local: String
)
