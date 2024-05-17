package com.example.hilfeapp.krankenwagen.navigation

/**
 * Sealed class que define las rutas de navegación de la aplicación.
 *
 * @property route String que representa la ruta de navegación.
 */
sealed class Routes(val route: String) {

    /**
     * Objeto que representa la ruta a la pantalla de usuario.
     */
    object PantallaUser : Routes("user")

    /**
     * Objeto que representa la ruta a la pantalla del mapa.
     */
    object PantallaMap : Routes("map")

    /**
     * Objeto que representa la ruta a la pantalla de opciones.
     */
    object PantallaOptions : Routes("options")
}
