package com.example.hilfeapp.krankenwagen.data

import com.google.android.gms.maps.model.LatLng

/**
 * Clase que enumera los tipos de ambulancias
 */
enum class AmbulanceTypes { doctor, nurse, driver }
/**
 * Clase que representa las Ambulancias
 * @property id almacena el id de la ambulancia
 * @property plate almacena la matrícula de la ambulancia
 * @property isFree indica si la ambulancia está disponible
 * @property types indica de que tipo es la ambulancia
 * @property hospital indica el hospital de referencia
 */
data class Ambulance(
    val id: String,
    val plate: String,
    var isFree: Boolean,
    var types: AmbulanceTypes,
    var hospital: String,
    var location: LatLng
){
    constructor() : this("amb1", "No definida", true, AmbulanceTypes.doctor, "", LatLng(0.0,0.0))
}

