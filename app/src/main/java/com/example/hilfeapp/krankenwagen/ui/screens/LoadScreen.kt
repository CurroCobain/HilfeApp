package com.example.hilfeapp.krankenwagen.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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

/**
 * Función composable que muestra la pantalla de inicialización de la aplicación.
 *
 * @param optionsViewModel ViewModel que maneja las opciones de la aplicación.
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 * @param dataBaseViewModel ViewModel que maneja la lógica relacionada con la base de datos.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppInitializationScreen(
    optionsViewModel: OptionsViewModel,
    locationViewModel: LocationViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel
) {
    // Recoge la imagen inicial del ViewModel
    val image by optionsViewModel.initialImage.collectAsState()
    val imagePainter: Painter = painterResource(id = image)

    // Variable que indica si se está cargando
    var isLoading by remember { mutableStateOf(true) }

    // Efecto lanzado que espera 2 segundos antes de cambiar el estado de carga
    LaunchedEffect(isLoading) {
        delay(2000) // Espera 2 segundos
        isLoading = false
    }

    // Caja que contiene la imagen de inicialización o el gestor de navegación
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            // Muestra la imagen de inicialización en el centro de la pantalla
            Image(
                painter = imagePainter,
                contentDescription = "Initialization Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            // Muestra el gestor de navegación una vez finalizada la carga
            NavManager(locationViewModel, optionsViewModel, doctorViewModel, dataBaseViewModel)
        }
    }
}