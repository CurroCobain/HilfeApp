package com.example.hilfeapp.krankenwagen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hilfeapp.krankenwagen.ui.screens.CallScreen
import CallViewModel
import com.example.hilfeapp.krankenwagen.ui.screens.OptionsScreen
import com.example.hilfeapp.krankenwagen.ui.screens.UserScreen

@Composable
fun NavManager(callViewModel: CallViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController ,
        startDestination = Routes.PantallaCall.route)
    {
        composable(Routes.PantallaCall.route){
            CallScreen(callViewModel,navController)
        }
        composable(Routes.PantallaOptions.route){
            OptionsScreen(navController)
        }
        composable(Routes.PantallaUser.route){
            UserScreen(navController)
        }
    }
}
