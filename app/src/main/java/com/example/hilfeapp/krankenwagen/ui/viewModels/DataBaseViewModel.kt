package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.krankenwagen.data.Ambulance
import com.example.hilfeapp.krankenwagen.data.Hospital
import com.example.hilfeapp.krankenwagen.data.Urgencia
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class DataBaseViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private var message = MutableStateFlow("")
    @RequiresApi(Build.VERSION_CODES.O)
    var urgencia2 = Urgencia(
        "paciente 2",
        "12345678Y",
        23,
        2,
        LatLng(36.688690, -6.156502),
        LocalDateTime.now(),
        "Se muere",
        Ambulance(),
        false
    )

    // listado de provincias
    val tempCounty = listOf("Almeria", "Cadiz", "Cordoba","Granada", "Huelva", "Jaen", "Malaga", "Sevilla" )

    //variable que se usa para determinar la provincia por la que se filtran los datos
    val provinciaFiltrar = MutableStateFlow("")


    //variable que se usa para determinar el hospital por el que se filtran los datos
    val hospitalFiltrar = MutableStateFlow(Hospital())

    // lista de ambulancias filtradas
    var listAmbulancias = MutableStateFlow(mutableListOf<Ambulance>())

    // lista de hospitales filtrados
    val listHospitals = MutableStateFlow(mutableListOf<Hospital>())

    // ambulancia actual del usuario
    val myAmb = MutableStateFlow(Ambulance())

    // lista de urgencias
    @RequiresApi(Build.VERSION_CODES.O)
    val listEr = MutableStateFlow<MutableList<Urgencia>>(mutableListOf(Urgencia(), urgencia2))


    // urgencia actual
    val miUrgenia = MutableStateFlow<Urgencia?>(null)


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
                .addOnFailureListener {
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
            .addOnFailureListener {
                // En caso de fallo al obtener las ambulancias filtradas por hospital
                message.value = "Error al obtener la lista de ambulancias"
            }
    }

    /**
     * Función que modifica el valor de provinciaFiltrar
     */
    fun setCounty(text: String, onSuccess: () -> Unit) {
        provinciaFiltrar.value = text
        onSuccess()
    }

    /**
     * Función que modifica el valor de ciudadFiltrar
     */
    fun setHosp(hosp: Hospital) {
        hospitalFiltrar.value = hosp
    }

    /**
     * Función para actualizar la ambulancia actual
     */
    fun setAmb(amb: Ambulance){
        myAmb.value= amb
    }

    /**
     * Función para actualizar la urgencia actual
     */
    fun setUrg(urg: Urgencia){
        miUrgenia.value = urg
    }

    /**
     * Función para actualizar el valor de la ambulancia asociada a la urgencia
     */
    fun intiUrg(){
        miUrgenia.value?.ambulance = myAmb.value
    }

    /**
     * Función para finalizar una urgencia
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun finishUrg(){
        miUrgenia.value?.complete = true
        // todo: Actualizar urgencia en base de datos, eliminar urgencia de variable interna
        listEr.value.remove(miUrgenia.value)
        miUrgenia.value = null

    }

    /**
     * Función para actualizar la ubicación de la ambulancia actual
     */
    fun setAmbLoc(location: LatLng){
        myAmb.value.location = location
    }
}