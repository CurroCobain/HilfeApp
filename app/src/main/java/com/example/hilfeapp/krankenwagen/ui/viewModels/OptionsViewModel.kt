// ------------------------ COMENTADO!! -----------------------------

package com.example.hilfeapp.krankenwagen.ui.viewModels

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.data.AppDatabase
import com.example.hilfeapp.krankenwagen.data.Options
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

/**
 * ViewModel para manejar la lógica de las opciones de la aplicación
 * @property color1 almacena el color principal de la aplicación
 * @property fondo almacena el fondo de la aplicación
 * @property initialImage almacena la imagen de carga de la aplicación
 */
class OptionsViewModel(private val database: AppDatabase) : ViewModel() {

    // Flujo mutable para el color principal de la aplicación
    val color1 = MutableStateFlow(Color(227, 176, 176))

    // Flujo mutable para el fondo de la aplicación
    val fondo = MutableStateFlow(R.drawable.fondo_rojo)

    // Flujo mutable para la imagen de carga inicial de la aplicación
    val initialImage = MutableStateFlow(R.drawable.portada_red)

    // Inicialización: se obtienen las opciones de configuración almacenadas en la base de datos
    init {
        viewModelScope.launch {
            val options = getOptions()
            options?.let {
                // Se actualizan los valores de los flujos con las opciones recuperadas de la base de datos
                color1.value = Color(it.color1, it.color2, it.color3)
                fondo.value = it.fondo
                initialImage.value = it.image
            }
        }
    }

    /**
     * Método para establecer el tema de la aplicación y guardar las opciones en la base de datos.
     * @param theme Índice del tema seleccionado.
     */
    fun setTheme(theme: Int) {
        when (theme) {
            0 -> {
                // Se actualizan los flujos en función del tema elegido
                color1.value = Color(227, 176, 176)
                fondo.value = R.drawable.fondo_rojo
                initialImage.value = R.drawable.portada_red
                // Se guarda el tema seleccionado en la base de datos
                viewModelScope.launch { saveOptions(color1.value, fondo.value, initialImage.value) }
            }
            1 -> {
                // Se actualizan los flujos en función del tema elegido
                color1.value = Color(176, 227, 178)
                fondo.value = R.drawable.fondo_verde
                initialImage.value = R.drawable.portada_green
                // Se guarda el tema seleccionado en la base de datos
                viewModelScope.launch { saveOptions(color1.value, fondo.value, initialImage.value) }
            }
            2 -> {
                // Se actualizan los flujos en función del tema elegido
                color1.value = Color(176, 187, 227)
                fondo.value = R.drawable.fondo_azul
                initialImage.value = R.drawable.portada_blue
                // Se guarda el tema seleccionado en la base de datos
                viewModelScope.launch { saveOptions(color1.value, fondo.value, initialImage.value) }
            }
        }
    }

    /**
     * Método para guardar las opciones de configuración en la base de datos.
     * @param color1 Color principal de la aplicación.
     * @param fondo Recurso de fondo de la aplicación.
     * @param image Recurso de imagen de carga inicial de la aplicación.
     */
    private suspend fun saveOptions(color1: Color, fondo: Int, image: Int) {
        // Extraemos los componentes de color ARGB
        val argb = color1.toArgb()
        val color1Int = Color(android.graphics.Color.red(argb), android.graphics.Color.green(argb), android.graphics.Color.blue(argb))


        val options = Options(color1Int.red, color1Int.green, color1Int.blue, fondo, image)
        // Eliminamos la entrada existente en la base de datos (si existe)
        database.optionsDao().deleteAllOptions()
        database.optionsDao().insertOptions(options)
    }


    /**
     * Método para obtener las opciones de configuración almacenadas en la base de datos.
     * @return Las opciones de configuración almacenadas, o null si no hay ninguna entrada en la base de datos.
     */
    private suspend fun getOptions(): Options? {
        return database.optionsDao().getOptions()
    }

    /**
     * Método para salir de la aplicación.
     */
    fun exit(){
        exitProcess(0)
    }
}
