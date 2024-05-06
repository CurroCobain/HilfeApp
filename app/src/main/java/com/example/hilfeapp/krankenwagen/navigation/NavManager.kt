package com.example.hilfeapp.krankenwagen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hilfeapp.krankenwagen.ui.screens.UserScreen
import com.example.hilfeapp.krankenwagen.ui.screens.OptionsScreen
import com.example.hilfeapp.krankenwagen.ui.screens.MapScreen
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel

@Composable
fun NavManager(
    locationViewModel: LocationViewModel,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel)
{
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Routes.PantallaAmb.route)
    {
        composable(Routes.PantallaAmb.route){
            UserScreen(navController, optionsViewModel)
        }
        composable(Routes.PantallaOptions.route){
            OptionsScreen(navController, optionsViewModel, doctorViewModel)
        }
        composable(Routes.PantallaUser.route){
            MapScreen(navController, locationViewModel, optionsViewModel)
           // MyMapScreen()
        }
    }
}
