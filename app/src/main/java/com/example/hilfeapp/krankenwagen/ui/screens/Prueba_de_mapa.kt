package com.example.hilfeapp.krankenwagen.ui.screens

import android.location.Geocoder
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

@Composable
fun MapWithMarkerAndAddress(
    initialPosition: LatLng,
    onAddressClicked: (String) -> Unit
) {
    val context = LocalContext.current
    val locationViewModel = LocationViewModel(context)
    var map: GoogleMap? by remember { mutableStateOf(null) }

    val mapView = remember {
        MapView(context).apply {
        }
    }

    AndroidView({ mapView }) { mapView ->
        mapView.getMapAsync { googleMap ->
            map = googleMap
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialPosition, 15f))

            googleMap.setOnMarkerClickListener { marker ->
                val address = locationViewModel.getAddressFromLatLng(marker.position)
                onAddressClicked(address)
                true
            }

            // Add a marker at the initial position
            googleMap.addMarker(MarkerOptions().position(initialPosition))
        }

        mapView.onResume()
    }
}


@Composable
fun MyMapScreen() {
    // Posición inicial del marcador
    val initialPosition = remember { LatLng(40.7128, -74.0060) } // Latitud y longitud de Nueva York

    MapWithMarkerAndAddress(
        initialPosition = initialPosition,
        onAddressClicked = { address ->
            // Aquí puedes hacer lo que quieras con la dirección, como mostrarla en un Snackbar o en otro lugar
            // Por ejemplo:
            // scaffoldState.snackbarHostState.showSnackbar("Dirección: $address")
        }
    )
}

@Preview
@Composable
fun PreviewMap(){
    MyMapScreen()
}

