package com.example.hilfeapp.krankenwagen.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hilfeapp.krankenwagen.ui.screens.UserScreen
import com.example.hilfeapp.krankenwagen.ui.screens.OptionsScreen
import com.example.hilfeapp.krankenwagen.ui.screens.MapScreen
import com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel

/**
 * Función composable que gestiona la navegación de la aplicación.
 *
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param optionsViewModel ViewModel que maneja la lógica de las opciones de la aplicación.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 * @param dataBaseViewModel ViewModel que maneja la lógica relacionada con la base de datos.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavManager(
    locationViewModel: LocationViewModel,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.PantallaUser.route
    ) {
        composable(Routes.PantallaUser.route) {
            UserScreen(navController, optionsViewModel, doctorViewModel, dataBaseViewModel)
        }
        composable(Routes.PantallaOptions.route) {
            OptionsScreen(navController, optionsViewModel, dataBaseViewModel, doctorViewModel)
        }
        composable(Routes.PantallaMap.route) {
            MapScreen(navController, locationViewModel, optionsViewModel, doctorViewModel, dataBaseViewModel)
            // MyMapScreen()
        }
    }
}
