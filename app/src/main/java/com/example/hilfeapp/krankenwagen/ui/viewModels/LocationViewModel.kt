// ------------------------ COMENTADO!! -----------------------------

package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.MainActivity
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.data.Urgencia
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.maps.android.compose.CameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.math.*

/**
 * ViewModel para manejar la lógica relacionada con la ubicación.
 *
 * @property fusedLocationClient proporciona el cliente de ubiccación
 * @property addressText texto de la dirección
 * @property userLocation coordenadas de la ubicación del usuario
 * @property urgencyLocation coordenadas de la ubicación de la urgencia
 * @property focusErAmb indica dónde si enfoca el mapa
 * @property editUrg gestiona cuando se muestra el diálogo con la información de la urgencia
 * @property showToast gestiona cuando se muestran aviso especiales en la app
 */
@SuppressLint("StaticFieldLeak")
class LocationViewModel : ViewModel() {
    lateinit var context: Context

    //Maneja cuando se muestran avisos especiales
    var showToast = MutableStateFlow(true)

    // Cliente de ubicación
    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    // Texto de la dirección
    var addressText = MutableStateFlow("")

    // Ubicación del usuario
    var userLocation = MutableStateFlow<LatLng?>(LatLng(0.0, 0.0))

    // Ubicación de la urgencia
    var urgencyLocation = MutableStateFlow<LatLng?>(null)

    // Gestiona la posición del foco del mapa
    var cameraPosition = MutableStateFlow(
        CameraPositionState(
            position = CameraPosition.fromLatLngZoom(
                LatLng(0.0, 0.0),
                16f
            )
        )
    )

    // Indica si el foco está en urgencia o ambulancia
    var focusErAmb = MutableStateFlow(false)

    // Se usa para mostrar el diálogo con la información de la urgencia
    var editUrg = MutableStateFlow(false)

    /**
     * Método para cambiar el foco entre urgencia y ambulancia
     */
    fun alterFocus() {
        focusErAmb.value = !focusErAmb.value
        updateCameraPosition()
    }

    /**
     * Actualiza la posición del foco en el mapa
     */
    private fun updateCameraPosition() {
        val position = if (focusErAmb.value) {
            userLocation.value
        } else {
            urgencyLocation.value
        }
        if (position != null) {
            setCameraPositionState(
                CameraPositionState(
                    position = CameraPosition.fromLatLngZoom(position, 16f)
                )
            )
        }
    }

    /**
     * Método para obtener la ubicación del usuario
     */
    @SuppressLint("MissingPermission")
    fun getUserLocation(onSuccess: () -> Unit) {
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                // Actualiza el MutableStateFlow con la ubicación del usuario
                userLocation.value = LatLng(location.latitude, location.longitude)
                onSuccess()
            }
        }
    }

    /**
     * Establece la ubicación de la urgencia en el mapa
     */
    fun setUrLocation(location: LatLng) {
        urgencyLocation.value = location
    }

    /**
     * Método para obtener la dirección a partir de las coordenadas
     */
    fun getAddressFromCoordinates(geocoder: Geocoder, locat: LatLng) {
        viewModelScope.launch(Dispatchers.IO) {
            val locLat = locat.latitude
            val locLong = locat.longitude
            val location = geocoder.getFromLocation(locLat, locLong, 1)
            if (location!!.isNotEmpty()) {
                val address = location[0]
                val addressStringBuilder = StringBuilder()
                for (i in 0..address.maxAddressLineIndex) {
                    addressStringBuilder.append(address.getAddressLine(i)).append("\n")
                }
                addressText.value = addressStringBuilder.toString()
            } else {
                addressText.value = "No se pudo obtener la dirección"
            }
        }
    }

    /**
     * Método para restablecer el texto de la dirección
     */
    fun resetAddressText() {
        addressText.value = ""
    }

    /**
     * Función que muestra u oculta el diálogo con la información de la urgencia
     */
    fun openCloseEditUrg() {
        editUrg.value = !editUrg.value
    }

    fun setCameraPositionState(position: CameraPositionState) {
        cameraPosition.value = position
    }

    /**
     * Cambia el valor de showToast
     */
    fun setToast() {
        showToast.value = !showToast.value
    }


    /**
     * Calcula la distancia en kms entre dos puntos en el mapa se usa para filtrar las urgencias en el radio de acción del mapa
     * @return devuelve la distancia en kms entre dos puntos
     */
    fun distanceBetween(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val R = 6371.0 // Radio de la Tierra en km

        // Convertir coordenadas de grados a radianes
        val lat1Rad = Math.toRadians(lat1)
        val lon1Rad = Math.toRadians(lon1)
        val lat2Rad = Math.toRadians(lat2)
        val lon2Rad = Math.toRadians(lon2)

        // Diferencias de coordenadas
        val dlat = lat2Rad - lat1Rad
        val dlon = lon2Rad - lon1Rad

        // Fórmula de Haversine
        val a = sin(dlat / 2).pow(2) + cos(lat1Rad) * cos(lat2Rad) * sin(dlon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        val distance = R * c

        return distance
    }
}