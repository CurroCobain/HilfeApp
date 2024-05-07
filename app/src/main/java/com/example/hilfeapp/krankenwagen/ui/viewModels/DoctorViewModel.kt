package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.krankenwagen.data.Ambulance
import com.example.hilfeapp.krankenwagen.data.Hospital
import com.example.hilfeapp.krankenwagen.data.Urgencia
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

    // Flujo mutable para la lista de ambulancias
    val listAmb = MutableStateFlow<MutableList<Any>>(mutableListOf())

    // Flujo mutable para la ambulancia del usuario
    val myAmbulance = MutableStateFlow<Ambulance?>(null)

    // Flujo mutable para el hospital del usuario
    val myHosp = MutableStateFlow<Hospital>(Hospital())

    var tempCounty = listOf("Almería", "Cadiz", "Córdoba","Granada", "Huelva", "Jaén", "Málaga", "Sevilla" )

    // Flujo mutable para la provincia
    val county = MutableStateFlow("")

    // Flujo mutable para la ciudad
    val city = MutableStateFlow("")

    // Flujo mutable para la lista de urgencias
    val listEr = MutableStateFlow<MutableList<Urgencia>>(mutableListOf())

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
    fun cambiaNombre(value: String) {
        nombreDoc.value = value
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
     * Método para cargar las ambulancias
     */
    fun loadAmbulances(){
        // TODO: Cargar lista de ambulancias de la base de datos
    }

    /**
     * Método para seleccionar una ambulancia
     */
    fun selectAmbulance(amb: Any){
        // TODO: Asignar a myAmbulance los valores de la ambulancia seleccionada
    }

    /**
     * Método para establecer el estado de la ambulancia como libre
     */
    fun setFree(){
        // TODO: Cambiar el valor del atributo isFree de la ambulancia actual
        // myAmbulance.value.isFree = !myAmbulance.value.isFree
        updateStatus()
    }

    /**
     * Método para aceptar una urgencia
     */
    fun acceptEr(urgencia: Urgencia){
        // TODO: Añadir aviso a la lista de avisos
        listEr.value.add(urgencia)
        setFree()
    }

    /**
     * Método para actualizar el estado de la ambulancia en la base de datos
     */
    fun updateStatus(){
        // TODO: Actualizar el estado de la ambulancia en la base de datos
    }

}