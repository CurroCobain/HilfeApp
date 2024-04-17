package com.example.hilfeapp.krankenwagen.navigation

sealed class Routes (val route: String){
    object PantallaAmb : Routes("call")
    object PantallaUser : Routes("user")
    object PantallaOptions : Routes("options")
}