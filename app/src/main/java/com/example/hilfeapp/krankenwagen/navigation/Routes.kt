package com.example.hilfeapp.krankenwagen.navigation

sealed class Routes (val route: String){
    object PantallaCall : Routes("call")
}