package com.example.hilfeapp.krankenwagen.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.krankenwagen.data.Ambulance
import com.example.hilfeapp.krankenwagen.data.Hospital
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DataBaseViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private var message = MutableStateFlow("")

    //variable que se uso para determinar la provincia por la que se filtran los datos
    val provinciaFiltrar = MutableStateFlow("")

    //variable que se uso para determinar la ciudad por la que se filtran los datos
    val ciudadFiltrar = MutableStateFlow("")


    // lista de ambulancias filtradas
    var listAmbulancias = MutableStateFlow(mutableListOf<Ambulance>())

    // lista de hospitales filtrados
    val listHospitals = MutableStateFlow(mutableListOf<Hospital>())

    /**
     * Obtiene la lista de hospitales para una provincia específica desde Firestore.
     * @param provincia La provincia para la cual se desean obtener los hospitales.
     * @param onSuccess La acción a ejecutar cuando se obtienen los hospitales exitosamente.
     */
    fun getHosp(provincia: String, onSuccess: () -> Unit) {
        // Se vacía la lista de hospitales para evitar duplicados
        listHospitals.value.clear()

        // Se inicia una corutina para la operación asíncrona
        viewModelScope.launch {
            // Se realiza la consulta a Firestore para obtener los hospitales de la provincia especificada
            firestore.collection("Hospitals").whereEqualTo("county", provincia).get()
                .addOnSuccessListener { documents ->
                    // Cuando se obtienen los documentos exitosamente
                    for (document in documents) {
                        // Se añade cada hospital a la lista
                        listHospitals.value.add(document.toObject(Hospital::class.java))
                        // Se ejecuta la acción onSuccess para manejar el éxito de la operación
                        onSuccess()
                    }
                }
                .addOnFailureListener { exception ->
                    // En caso de fallo al obtener los hospitales
                    message.value = "Error al obtener la lista de hospitales"
                }
        }
    }

    /**
     * Filtra las ambulancias por hospital de referencia desde Firestore.
     * @param hospital El hospital de referencia por el cual se desean filtrar las ambulancias.
     * @param onSuccess La acción a ejecutar cuando se obtienen las ambulancias exitosamente.
     */
    fun getAmb(hospital: String, onSuccess: () -> Unit) {
        // Se limpia la caché local de Firestore para asegurar la obtención de los datos más recientes
        firestore.clearPersistence()

        // Se vacía la lista de ambulancias para evitar duplicados
        listAmbulancias.value.clear()

        // Se realiza la consulta a Firestore para obtener las ambulancias filtradas por hospital de referencia
        firestore.collection("Ambulances").whereEqualTo("hospital", hospital).get()
            .addOnSuccessListener { documents ->
                // Cuando se obtienen los documentos exitosamente
                for (document in documents) {
                    // Se añade cada ambulancia filtrada por hospital a la lista
                    listAmbulancias.value.add(document.toObject(Ambulance::class.java))
                    // Se ejecuta la acción onSuccess para manejar el éxito de la operación
                    onSuccess()
                }
            }
            .addOnFailureListener { exception ->
                // En caso de fallo al obtener las ambulancias filtradas por hospital
                message.value = "Error al obtener la lista de ambulancias"
            }
    }

    /**
     * Función que modifica el valor de provinciaFiltrar
     */
    fun setProv(text: String) {
        provinciaFiltrar.value = text
    }

    /**
     * Función que modifica el valor de ciudadFiltrar
     */
    fun setCity(text: String) {
        ciudadFiltrar.value = text
    }
}