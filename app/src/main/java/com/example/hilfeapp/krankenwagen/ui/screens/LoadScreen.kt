package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.hilfeapp.krankenwagen.navigation.NavManager
import com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.delay

@Composable
fun AppInitializationScreen(
    optionsViewModel: OptionsViewModel,
    locationViewModel: LocationViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel) {
    val image by optionsViewModel.initialImage.collectAsState()
    val imagePainter: Painter = painterResource(id = image)

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(isLoading) {
        delay(2000) // Espera 2 segundos
        isLoading = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            // Muestra la imagen en el centro de la pantalla
            Image(
                painter = imagePainter,
                contentDescription = "Initialization Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            NavManager(locationViewModel, optionsViewModel, doctorViewModel, dataBaseViewModel)
        }
    }
}