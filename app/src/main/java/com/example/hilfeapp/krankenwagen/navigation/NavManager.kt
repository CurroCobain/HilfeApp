package com.example.hilfeapp.krankenwagen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hilfeapp.krankenwagen.ui.screens.CallScreen
import CallViewModel
import com.example.hilfeapp.krankenwagen.ui.screens.MyMapScreen
import com.example.hilfeapp.krankenwagen.ui.screens.OptionsScreen
import com.example.hilfeapp.krankenwagen.ui.screens.UserScreen
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel

@Composable
fun NavManager(callViewModel: CallViewModel, locationViewModel: LocationViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Routes.PantallaUser.route)
    {
        composable(Routes.PantallaCall.route){
            CallScreen(callViewModel,navController)
        }
        composable(Routes.PantallaOptions.route){
            OptionsScreen(navController)
        }
        composable(Routes.PantallaUser.route){
            //UserScreen(navController, locationViewModel)
            MyMapScreen()
        }
    }
}
