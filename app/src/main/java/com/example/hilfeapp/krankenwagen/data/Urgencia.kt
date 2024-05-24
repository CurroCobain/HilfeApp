package com.example.hilfeapp.krankenwagen.data

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.DocumentSnapshot
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Clase "Urgencia", que almacena la información de la emergencia para transmitirla al
 * servicio de emergencias
 * @property id: identificador de la urgencia
 * @property name: nombre y apellidos del paciente
 * @property doc: documento de identidad del usuario
 * @property age: edad del usuario
 * @property priority: indica el nivel de prioridad de la emergencia
 * @property location: localización del usuario
 * @property date: fecha de la urgencia
 * @property issues: descripción de la urgencia
 * @property ambulance: matrícula de la ambulancia que gestiona la urgencia
 * @property complete: indica si la urgencia ha sido resuelta
 */
data class Urgencia(
    val id: String,
    val name: String,
    val doc: String,
    val age: Int,
    val priority: Int,
    val location: LatLng,
    val date: Timestamp?,
    val issues: String,
    var ambulance: String,
    var complete: Boolean
){



    companion object {
        /**
         * Función para deserializar un objeto urgencia desde la base de datos
         * Se ha personalizado para evitar errores
         */
        @SuppressLint("NewApi")
        fun fromDocumentSnapshot(documentSnapshot: DocumentSnapshot): Urgencia {
            val id = documentSnapshot.getString("id") ?: ""
            val name = documentSnapshot.getString("name") ?: ""
            val doc = documentSnapshot.getString("doc") ?: ""
            val age = documentSnapshot.getLong("age")?.toInt() ?: 0
            val priority = documentSnapshot.getLong("priority")?.toInt() ?: 0
            val locationMap = documentSnapshot.get("location") as? Map<*, *>
            val location = if (locationMap != null) {
                val latitude = locationMap["latitude"] as? Double ?: 0.0
                val longitude = locationMap["longitude"] as? Double ?: 0.0
                LatLng(latitude, longitude)
            } else {
                LatLng(0.0, 0.0)
            }
            var date = documentSnapshot.getDate("date") as? Timestamp
            if(date == null){
                date = Timestamp(System.currentTimeMillis())
            }
            val issues = documentSnapshot.getString("issues") ?: ""
            val ambulance = documentSnapshot.getString("ambulance") ?: ""
            return Urgencia(id, name, doc, age, priority, location, date, issues, ambulance,false)
        }

        fun urgenciaToMap(urgencia: Urgencia): MutableMap<String, Any?> {
            return mutableMapOf(
                "id" to urgencia.id,
                "name" to urgencia.name,
                "doc" to urgencia.doc,
                "age" to urgencia.age,
                "priority" to urgencia.priority,
                "location" to mapOf(
                    "latitude" to urgencia.location.latitude,
                    "longitude" to urgencia.location.longitude
                ),
                "date" to urgencia.date,
                "issues" to urgencia.issues,
                "ambulance" to urgencia.ambulance,
                "complete" to urgencia.complete
            )
        }
        fun mapToUrgencia(map: Map<String, Any?>): Urgencia {
            val locationMap = map["location"] as Map<String, Any>
            return Urgencia(
                id = map["id"] as String,
                name = map["name"] as String,
                doc = map["doc"] as String,
                age = map["age"] as Int,
                priority = map["priority"] as Int,
                location = LatLng(
                    locationMap["latitude"] as Double,
                    locationMap["longitude"] as Double
                ),
                date = map["date"] as? Timestamp,
                issues = map["issues"] as String,
                ambulance = map["ambulance"] as String,
                complete = map["complete"] as Boolean
            )
        }
    }

    // Constructor sin parámetros de la clase
    @SuppressLint("NewApi")
    constructor() : this(
        "urg0",
        "Paciente1",
        "30876923H",
        24,
        1,
        LatLng(36.678804, -6.143728),
        Timestamp(System.currentTimeMillis()),
        "Parada cardio respiratoria",
        "No definida",
        false
        )
}



