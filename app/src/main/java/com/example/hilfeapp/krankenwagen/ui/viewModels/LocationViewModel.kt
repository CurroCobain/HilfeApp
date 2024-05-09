// ------------------------ COMENTADO!! -----------------------------

package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel para manejar la lógica relacionada con la ubicación
 */
@SuppressLint("StaticFieldLeak")
class LocationViewModel(private val context: Context) : ViewModel() {

    // Cliente de ubicación
    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    // texto de la dirección
    var addressText = MutableStateFlow("")

    // ubicación del usuario
    var userLocation = MutableStateFlow<LatLng?>(null)

    // ubicación de urgencia
    var emergencyLocation = MutableStateFlow<LatLng?>(null)

    // indica si el foco está en urgencia o ambulancia
    var focusErAmb = MutableStateFlow(true)

    /**
     * Método para cambiar el foco entre urgencia y ambulancia
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
