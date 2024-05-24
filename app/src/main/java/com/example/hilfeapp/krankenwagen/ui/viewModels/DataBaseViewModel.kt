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
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel que gestiona la interacción con la base de datos y los datos relacionados con ella.
 *
 * @property message mensaje de respuesta
 * @property tempCounty listado de provincias para mostrar en la lista de filtrado
 * @property provinciaFiltrar provincia por la que se filtran los datos
 * @property hospitalFiltrar hospital por el que se filtran los datos
 * @property listAmbulancias listado de las matrículas de las ambulancias filtradas
 * @property myAmb matrícula de la ambulancia actual del usuario
 * @property listEr lista de las urgencias sin finalizar
 * @property miUrgencia urgencia que se está gestionando actualmente
 */
class DataBaseViewModel : ViewModel() {
    var firestore = Firebase.firestore
    val message = MutableStateFlow("")

    // listado de provincias
    val tempCounty =
        listOf("Almeria", "Cadiz", "Cordoba", "Granada", "Huelva", "Jaen", "Malaga", "Sevilla")

    //variable que se usa para determinar la provincia por la que se filtran los datos
    val provinciaFiltrar = MutableStateFlow("")

    //variable que se usa para determinar el hospital por el que se filtran los datos
    val hospitalFiltrar = MutableStateFlow(Hospital())

    // lista de ambulancias filtradas
    var listAmbulancias = MutableStateFlow(mutableListOf(""))

    // lista de hospitales filtrados
    val listHospitals = MutableStateFlow(mutableListOf<Hospital>())

    // ambulancia actual del usuario
    val myAmb = MutableStateFlow("")

    // lista de urgencias
    @RequiresApi(Build.VERSION_CODES.O)
    val listEr = MutableStateFlow<MutableList<Urgencia>>(mutableListOf())

    // urgencia actual
    val miUrgencia = MutableStateFlow<Urgencia?>(null)





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
        viewModelScope.launch {
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
                        listAmbulancias.value.add(getPlateFromDocumentSnapshot(document))
                        // Se ejecuta la acción onSuccess para manejar el éxito de la operación
                        onSuccess()
                    }
                }
                .addOnFailureListener {
                    // En caso de fallo al obtener las ambulancias filtradas por hospital
                    message.value = "Error al obtener la lista de ambulancias"
                }
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
     * Función para actualizar la ambulancia en uso
     */
    fun setAmb(amb: String) {
        myAmb.value = amb
        viewModelScope.launch {
            firestore.collection("Ambulances")
                .whereEqualTo("plate", myAmb.value)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        document.reference.update("free", true)
                        message.value = "Ambulancia seleccionada"
                    }
                }
                .addOnFailureListener {
                    message.value = "Error al seleccionar la ambulancia"
                }
        }
    }

    /**
     * Función para actualizar la ambulancia en uso
     */
    fun unSetAmb(onSuccess: () -> Unit) {
        viewModelScope.launch {
            firestore.collection("Ambulances")
                .whereEqualTo("plate", myAmb.value)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        document.reference.update("free", false)
                        message.value = "Ambulancia deseleccionada"
                        onSuccess()
                    }
                    myAmb.value = ""
                }
                .addOnFailureListener {
                    message.value = "Error al deseleccionar la ambulancia"
                }
        }
    }



    /**
     * Función para actualizar la urgencia actual
     */
    fun setUrg(urg: Urgencia) {
        miUrgencia.value = urg
    }

    /**
     * Función para actualizar el valor de la ambulancia asociada a la urgencia
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun intiUrg() {
        miUrgencia.value?.ambulance = myAmb.value
        updateUrgenciasIfMatches(miUrgencia.value!!) {
        }
    }

    /**
     * Función para finalizar una urgencia
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun finishUrg(onSuccess: () -> Unit) {
        miUrgencia.value?.complete = true
        viewModelScope.launch {
            updateUrgenciasIfMatches(miUrgencia.value!!) {}
            onSuccess()
        }
    }


    /**
     * Función para actualizar la ubicación de la ambulancia actual
     */
    fun setAmbLoc(location: LatLng) {
        viewModelScope.launch {
            updateAmbulanceLocation(location)
        }
    }

    /**
     * Función para obtener la lista de urgencias de la base de datos
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getUrgencies(onSuccess: () -> Unit) {
        listEr.value.clear()
        viewModelScope.launch {
            firestore.collection(("Urgencias"))
                .whereEqualTo("complete", false)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        listEr.value.add(Urgencia.fromDocumentSnapshot(document))
                        message.value = "Listado actualizado"
                        onSuccess()
                    }
                }
                .addOnFailureListener {
                    message.value = "Error al recuperar las urgencias"
                }
        }
    }

    /**
     * Función para actualizar una urgencia si coincide con la actual que se está gestionando
     * @param miUrgencia urgencia actual
     * @param onSuccess acción a ejecutar si se actualiza la ambulancia con éxito
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateUrgenciasIfMatches(miUrgencia: Urgencia, onSuccess: () -> Unit) {

        val urgenciasCollection = firestore.collection("Urgencias")

        // Realizar una consulta para recuperar todas las urgencias que coinciden con doc y location de miUrgencia
        val query: Query = urgenciasCollection
            .whereEqualTo("id", miUrgencia.id)

        query.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    val urgencia = Urgencia.fromDocumentSnapshot(document)

                    // Actualizar la urgencia solo si es diferente de miUrgencia
                    if (urgencia != miUrgencia) {
                        // Actualizar la urgencia en la base de datos
                        updateUrgencia(document.id, miUrgencia)
                        onSuccess()
                    }
                }
            }
            .addOnFailureListener { e ->
                // Manejar el error al obtener las urgencias
                println("Error al obtener las urgencias: $e")
            }
    }

    /**
     * Función que recibe una urgencia y la actualiza en la base de datos
     * @param urgenciaId id de la urgencia
     * @param urgencia urgencia actual
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateUrgencia(urgenciaId: String, urgencia: Urgencia) {
        val urgenciasCollection = firestore.collection("Urgencias")

        val data = hashMapOf(
            "id" to urgencia.id,
            "name" to urgencia.name,
            "doc" to urgencia.doc,
            "age" to urgencia.age,
            "priority" to urgencia.priority,
            "location" to hashMapOf(
                "latitude" to urgencia.location.latitude,
                "longitude" to urgencia.location.longitude
            ),
            "date" to urgencia.date,
            "issues" to urgencia.issues,
            "ambulance" to urgencia.ambulance,
            "complete" to urgencia.complete
        )

        urgenciasCollection.document(urgenciaId)
            .update(data as Map<String, Any>)
            .addOnSuccessListener {
                // La urgencia se actualizó exitosamente
                getUrgencies {  }
            }
            .addOnFailureListener { e ->
                // Ocurrió un error al actualizar la urgencia
                println("Error al actualizar la urgencia: $e")
            }
    }

    /**
     * Función para actualizar la ubicación de la ambulancia en la base de datos de Firestore
     */
    private fun updateAmbulanceLocation(location: LatLng) {
        val data = hashMapOf(
            "ambLocation" to hashMapOf(
                "latitude" to location.latitude,
                "longitude" to location.longitude
            )
        )
        // Consultamos la ambulancia por su placa
        firestore.collection("Ambulances")
            .whereEqualTo("plate", myAmb.value)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    // Actualizamos los datos de ubicación en el documento correspondiente
                    document.reference.update(data as Map<String, Any>)
                        .addOnSuccessListener {
                            message.value = "La ubicación de la ambulancia se actualizó exitosamente en Firestore"
                        }
                        .addOnFailureListener { e ->
                            // Ocurrió un error al actualizar la ubicación de la ambulancia en Firestore
                            message.value = "Error al actualizar la ubicación de la ambulancia: $e"
                        }
                }
            }
            .addOnFailureListener { e ->
                // Ocurrió un error al obtener la ambulancia de Firestore
                message.value = "Error al obtener la ambulancia: $e"
            }
    }

    /**
     * Función para obtener la matrícula de una ambulancia concreta en la base de datos
     */
    private fun getPlateFromDocumentSnapshot(documentSnapshot: DocumentSnapshot): String {
        return documentSnapshot.getString("plate") ?: ""
    }

    /**
     * función para actualizar el valor del mensaje del sistema
     */
    fun updateMessage(newValue: String) {
        message.value = newValue
    }

    /**
     * Función para modificar el valor de miUrgencia y eliminarla del listado de urgencias sin finalizar
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun setNull(onSuccess: () -> Unit){
        miUrgencia.value = null
        onSuccess()
    }
}


