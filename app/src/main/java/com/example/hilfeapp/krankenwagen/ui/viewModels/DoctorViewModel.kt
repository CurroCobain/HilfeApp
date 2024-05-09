package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DoctorViewModel : ViewModel(){
    // Instancias de Firebase
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore
    // Flujo mutable para el texto del documento
    val documentText = MutableStateFlow("")

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
                // Utiliza el servicio de autenticación de Firebase para validar al usuario
                // por email y contraseña
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

}