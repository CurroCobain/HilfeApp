package com.example.hilfeapp.krankenwagen.data

//--------------- no usado hasta ahora, comentar para posible mejora ------------------

/**
 * Clase Benutzer ("usuario"), que almacena la información del usuario para transmitirla al
 * servicio de emergencias
 * @property name: nombre y apellidos del usuario
 * @property doc: documento de identidad del usuario
 * @property age: edad del usuario
 * @property location: localización del usuario
 * @see Location
 * @property issues: lista de enfermedades o características importantes del usuario
 */
data class Benutzer(
    val name: String,
    val doc: String,
    val age: Int,
    val location: Location,
    val issues: MutableList<String>
)

/**
 * Clase Location, almacena la localización del usuario
 * @property county: provincia del usuario
 * @property citu: localidad del usuario
 * @property cp: código postal del usuario
 * @property street: calle del usuario
 * @property number: número de la calle
 * @property other: información adicional de la dirección
 */
data class Location (
    val county: String,
    val city: String,
    val cp: Int,
    val street: String,
    val number: Int,
    val other: String
)
