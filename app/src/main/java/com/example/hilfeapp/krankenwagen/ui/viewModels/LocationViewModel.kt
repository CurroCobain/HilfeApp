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
 * ViewModel para manejar la lógica relacionada con la ubicación.
 *
 * @property fusedLocationClient proporciona el cliente de ubiccación
 * @property addressText texto de la dirección
 * @property userLocation coordenadas de la ubicación del usuario
 * @property urgencyLocation coordenadas de la ubicación de la urgencia
 * @property focusErAmb indica dónde si enfoca el mapa
 * @property editUrg gestiona cuando se muestra el diálogo con la información de la urgencia
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

    // ubicación de la urgencia
    var urgencyLocation = MutableStateFlow<LatLng?>(null)


    // indica si el foco está en urgencia o ambulancia
    var focusErAmb = MutableStateFlow(false)

    // se usa para mostrar el diálogo con la información de la urgencia
    var editUrg = MutableStateFlow(false)

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
     * Establece la ubicación de la urgencia en el mapa
     */
    fun setUrLocation(location: LatLng){
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
    fun resetAddressText(){
        addressText.value = ""
    }

    /**
     * Función que muestra u oculta el diálogo con la información de la urgencia
     */
    fun openCloseEditUrg(){
        editUrg.value = !editUrg.value
    }
}
