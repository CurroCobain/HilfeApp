package com.example.hilfeapp.krankenwagen.data

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.gms.maps.model.LatLng
import java.time.LocalDateTime

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
    val date: LocalDateTime,
    val issues: String,
    var ambulance: Ambulance?,
    var complete: Boolean
){


    @SuppressLint("NewApi")
    constructor() : this(
        "Paciente1",
        "30876923H",
        24,
        1,
        LatLng(36.678804, -6.143728),
        LocalDateTime.now(),
        "Parada cardio respiratoria",
        Ambulance(),
        false
        )
}

