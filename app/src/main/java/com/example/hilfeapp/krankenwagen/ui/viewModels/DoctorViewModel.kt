package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


/**
 * ViewModel que gestiona lo referente al usuario, iniciar/cerrar sesión, obtener el nombre, etc.
 * @property sesionMessage almacena el mensaje del sistema
 * @property nombreDoc almacena el nombre del doctor actual
 * @property nuevoPass almacena el password del doctor actual
 * @property nuevoMail almacena el mail del doctor actual
 * @property userRegistered booleano que indica si hay un usuario registrado o no
 */
class DoctorViewModel : ViewModel(){
    // Instancias de Firebase
    var auth: FirebaseAuth = Firebase.auth
    var firestore = Firebase.firestore
/*
    // Flujo mutable para el texto del documento de momento no se usa, guardar para posible mejora
    val documentText = MutableStateFlow("")

 */

    // Estado del mensaje de sesión
    var sesionMessage = MutableStateFlow("")

    // Nombre del Doctor actual
    var nombreDoc = MutableStateFlow("")
        private set

    // Password del usuario actual
    var nuevoPass = MutableStateFlow("")
        private set

    // Correo del usuario actual
    var nuevoMail = MutableStateFlow("")
        private set

    // Flujo mutable para indicar si el usuario está registrado
    val userRegistered = MutableStateFlow(false)


    /**
     * Inicia sesión
     */
    fun sesionInit(onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                // Utiliza el servicio de autenticación de Firebase para validar al usuario por email y contraseña
                auth.signInWithEmailAndPassword(nuevoMail.value, nuevoPass.value)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onSuccess()
                        } else {
                            Log.d("ERROR EN FIREBASE", "Usuario y/o contrasena incorrectos")
                            sesionMessage.value = "Usuario y/o contrasena incorrectos"
                        }
                    }
            } catch (e: Exception) {
                Log.d("ERROR EN JETPACK", "ERROR: ${e.localizedMessage}")
                sesionMessage.value = "Usuario y/o contrasena incorrectos"
            }
        }
    }


    /**
     * Cierra la sesión del usuario actual
     */
    fun cerrarSesion(onSuccess: () -> Unit) {
        viewModelScope.launch {
            try {
                // Cierra la sesión del usuario actual
                auth.signOut()
                onSuccess()
            } catch (e: Exception) {
                sesionMessage.value ="Error al cerrar sesión: ${e.localizedMessage}"
            }
        }
    }

    /**
     * Asigna el nombre del usuario
     */
    fun cambiaNombre() {
        // Realiza la consulta a Firestore para obtener el nombre del usuario actual
        firestore.collection("Users").whereEqualTo("userId", auth.currentUser?.uid).get()
            .addOnSuccessListener { documents ->
                // Cuando se obtienen los documentos exitosamente
                for (document in documents) {
                    // Asigna el nombre del usuario a la variable `nombreDoc`
                    nombreDoc.value = document.getString("name")!!
                }
            }
            .addOnFailureListener { exception ->
                nombreDoc.value = ""
                // En caso de fallo al obtener el nombre del usuario
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }

    /**
     * Asigna el password del usuario
     */
    fun cambiaPass(value: String) {
        nuevoPass.value = value
    }

    /**
     * Asigna el correo del usuario
     */
    fun cambiaMail(valor: String) {
        nuevoMail.value = valor
    }

    /**
     * Cambia el valor de userRegistered
     */
    fun trueFalseSesionInit(){
        userRegistered.value = !userRegistered.value
    }

    /**
     * Modifica el valor del mensaje del sistema
     */
    fun setMessage(value: String){
        sesionMessage.value = value
    }
}