package com.example.hilfeapp.krankenwagen.data

import com.google.android.gms.maps.model.LatLng
import java.util.Date

/**
 * Clase "Urgencia", que almacena la información de la emergencia para transmitirla al
 * servicio de emergencias
 * @property name: nombre y apellidos del paciente
 * @property doc: documento de identidad del usuario
 * @property age: edad del usuario
 * @property priority: indica el nivel de prioridad de la emergencia
 * @property location: localización del usuario
 * @property date: fecha de la urgencia
 * @property issues: descripción de la urgencia
 */
data class Urgencia(
    val name: String,
    val doc: String,
    val age: Int,
    val priority: Int,
    val location: LatLng,
    val date: Date,
    val issues: String
)

