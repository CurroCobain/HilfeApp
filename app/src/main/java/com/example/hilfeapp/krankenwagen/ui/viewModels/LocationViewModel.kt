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


@SuppressLint("StaticFieldLeak")
class LocationViewModel(private val context: Context) : ViewModel() {

    // Cliente de ubicación
    private val fusedLocationClient: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }
    var addressText = MutableStateFlow("")
    var userLocation = MutableStateFlow<LatLng?>(null)
    var emergencyLocation = MutableStateFlow<LatLng?>(null)
    var focusErAmb = MutableStateFlow<Boolean>(true)

    fun alterFocusEr(){
        focusErAmb.value = true
    }
    fun alterFocusAmb(){
        focusErAmb.value = false
    }

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

    fun resetAddressText(){
        addressText.value = ""
    }

    fun updateStatus(){
        // TODO:
    }

    fun updateLocation(){
        // TODO:
    }
}


