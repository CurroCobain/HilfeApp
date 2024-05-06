package com.example.hilfeapp.krankenwagen.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.hilfeapp.krankenwagen.data.Urgencia
import kotlinx.coroutines.flow.MutableStateFlow

class DoctorViewModel(): ViewModel(){
    // Flujo mutable para el texto del documento
    val documentText = MutableStateFlow("")

    // Flujo mutable para indicar si el usuario está registrado
    val userRegistered = MutableStateFlow(false)

    // Flujo mutable para la lista de ambulancias
    val listAmb = MutableStateFlow<MutableList<Any>>(mutableListOf())

    // Flujo mutable para la ambulancia del usuario
    val myAmbulance = MutableStateFlow<Any?>(null)


    var tempCounty = listOf("Almería", "Cadiz", "Córdoba","Granada", "Huelva", "Jaén", "Málaga", "Sevilla" )
    var tempCity = listOf("Almería", "Cadiz", "Córdoba","Granada", "Huelva", "Jaén", "Málaga", "Sevilla" )

    // Flujo mutable para la provincia
    val county = MutableStateFlow("")

    // Flujo mutable para la ciudad
    val city = MutableStateFlow("")

    // Flujo mutable para la lista de urgencias
    val listEr = MutableStateFlow<MutableList<Urgencia>>(mutableListOf())

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