// ------------------------ COMENTADO!! -----------------------------

package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import android.location.Geocoder
import com.example.hilfeapp.krankenwagen.data.Urgencia

/**
 * ViewModel para manejar la lógica relacionada con la ubicación
 */
@SuppressLint("StaticFieldLeak")
class LocationViewModel(private val context: Context) : ViewModel() {

    // Cliente de ubicación
    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    // Flujo mutable para el texto de la dirección
    var addressText = MutableStateFlow("")

    // Flujo mutable para la ubicación del usuario
    var userLocation = MutableStateFlow<LatLng?>(null)

    // Flujo mutable para la ubicación de emergencia
    var emergencyLocation = MutableStateFlow<LatLng?>(null)

    // Flujo mutable para indicar el foco en urgencias o ambulancias
    var focusErAmb = MutableStateFlow<Boolean>(true)

    /**
     * Método para cambiar el foco entre urgencias y ambulancias
     */
    fun alterFocus(){
        focusErAmb.value = !focusErAmb.value
    }

    /**
     * Método para obtener la ubicación del usuario
     */
    @SuppressLint("MissingPermission")
    fun getUserLocation() {
        viewModelScope.launch {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    // Actualiza el MutableStateFlow con la ubicación del usuario
                    userLocation.value = LatLng(location.latitude, location.longitude)
                }
            }
        }
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
    fun resetAddressText(){
        addressText.value = ""
    }

    /**
     * Método para actualizar la ubicación
     */
    fun updateLocation(){
        // TODO: Actualizar la ubicación
    }
}
