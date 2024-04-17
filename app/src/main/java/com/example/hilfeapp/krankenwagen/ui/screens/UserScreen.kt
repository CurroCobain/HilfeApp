package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.common.collect.Maps
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun UserScreen(navController: NavController, locationViewModel: LocationViewModel){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val locationText by locationViewModel.textLocation.collectAsState()
    val lat  by locationViewModel.latLoc.collectAsState()
    val long by locationViewModel.longLoc.collectAsState()
    val textResp by locationViewModel.textRespond.collectAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController)
            }
        })
    {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize())
        {
            MyMap()

            Button(onClick = {
                // locationViewModel.launchLocation()
            })
            {
                Text(text = "Localización")
            }
            Button(onClick = {
                // locationViewModel.getAddressFromCoordinates(lat, long)
            })
            {
                Text(text = "Dirección")
            }
            Text(text = locationText,
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
            Text(text = textResp,
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
            Text(text = lat.toString(),
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
            Text(text = long.toString(),
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
        }
    }
}

@Composable
fun MyMap(){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
    /*
    GoogleMap(modifier = Modifier
        .fillMaxHeight(0.5f)
        .fillMaxWidth(),
        properties = MapProperties(isMyLocationEnabled = true),
        uiSettings = MapUiSettings(mapToolbarEnabled = true)
        )
    {

    }

     */
}