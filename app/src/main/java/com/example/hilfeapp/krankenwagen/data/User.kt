package com.example.hilfeapp.krankenwagen.data

// ------------------------------------ No se usa revisar y borrar --------------------------

// Posible uso para ampliación de funcionalidades

/**
 * Clase Usuario del sistema
 * @property name almacena el nombre del usuario
 * @property email almacena el email del usuario
 * @property userId almacena el id del usuario
 */
data class User (
    val userId: String,
    val email: String,
    var name: String
)