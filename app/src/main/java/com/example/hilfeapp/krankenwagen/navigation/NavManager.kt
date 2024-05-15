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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavManager(
    locationViewModel: LocationViewModel,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel)
{
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Routes.PantallaAmb.route)
    {
        composable(Routes.PantallaAmb.route){
            UserScreen(navController, optionsViewModel, doctorViewModel, dataBaseViewModel)
        }
        composable(Routes.PantallaOptions.route){
            OptionsScreen(navController, optionsViewModel, dataBaseViewModel, doctorViewModel)
        }
        composable(Routes.PantallaUser.route){
            MapScreen(navController, locationViewModel, optionsViewModel, doctorViewModel, dataBaseViewModel)
           // MyMapScreen()
        }
    }
}
