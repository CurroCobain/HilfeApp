package com.example.hilfeapp.krankenwagen.data

/**
 * Clase Hospital
 * @property id almacena el id del hospital
 * @property name almacena el nombre del hospital
 * @property county almacena la provincia del hospital
 * @property city almacena la localidad del hospital
 * @property address almacena la direccion del hospital
 */
data class Hospital(
    val id: String,
    var name: String,
    val county: String,
    val city: String,
    val address: String,
)
{
    // Constructor sin parámetros de la clase
    constructor(): this("hosp1", " Hospital ", "Cádiz","Cádiz","Calle 1 de Cádiz")
}