package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.getSystemService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.krankenwagen.apis.RetrofitInstance
import com.google.android.gms.maps.model.LatLng
// import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.IOException
import kotlin.coroutines.resume

@SuppressLint("StaticFieldLeak")
class LocationViewModel( private val context: Context) : ViewModel() {

    var textLocation = MutableStateFlow("")
    var latLoc = MutableStateFlow(0.0)
    var longLoc = MutableStateFlow(0.0)
    val textRespond = MutableStateFlow("")
    val geocoder = Geocoder(context)
    var addressText = ""

    fun getAddressFromLatLng(latLng: LatLng): String {
        try {
            val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    val address = addresses[0]
                    addressText = address.getAddressLine(0)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return addressText
    }
/*
    fun launchLocation() {
        viewModelScope.launch { getUserLocation() }
    }

    @SuppressLint("MissingPermission")
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun getUserLocation(): Location? {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        val userLocationPermission = true
        val locationManager: LocationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled: Boolean =
            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                    locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (!!isGpsEnabled || !!userLocationPermission) {
            return null
        }

        return suspendCancellableCoroutine { cont ->
            fusedLocationProviderClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        cont.resume(result) {
                            latLoc.value = result.latitude
                            longLoc.value = result.longitude
                            textRespond.value = "Funciona!"
                        }
                    }
                    return@suspendCancellableCoroutine
                }

                addOnSuccessListener {
                    val latitude = it.latitude
                    val longitude = it.longitude
                    latLoc.value = latitude
                    longLoc.value = longitude
                    textRespond.value = "Funciona!"
                    cont.resume(it)
                }

                addOnFailureListener {
                    textRespond.value = " nop "
                    cont.resume(null)
                }

                addOnCanceledListener {
                    textRespond.value = " nop "
                    cont.resume(null)
                }
            }
        }
    }

    fun getAddressFromCoordinates(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.geocodingService.getAddress("json", lat, lon)
            if (response.isNotEmpty()) {
                val firstResult = response[0]
                textLocation.value = firstResult.display_name
            }
        }
    }

 */
}



