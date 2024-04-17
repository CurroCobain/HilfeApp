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

class OptionsViewModel(private val database: AppDatabase) : ViewModel() {

    val color1 = MutableStateFlow(Color(227, 176, 176))
    val fondo = MutableStateFlow(R.drawable.fondo_rojo)

    init {
        viewModelScope.launch {
            val options = getOptions()
            options?.let {
                color1.value = Color(it.color1, it.color2, it.color3)
                fondo.value = it.fondo
            }
        }
    }

    fun setTheme(theme: Int) {
        when (theme) {
            0 -> {
                color1.value = Color(227, 176, 176)
                fondo.value = R.drawable.fondo_rojo
                viewModelScope.launch { saveOptions(color1.value, fondo.value) }
            }
            1 -> {
                color1.value = Color(176, 227, 178)
                fondo.value = R.drawable.fondo_verde
                viewModelScope.launch { saveOptions(color1.value, fondo.value) }
            }
            2 -> {
                color1.value = Color(176, 187, 227)
                fondo.value = R.drawable.fondo_azul
                viewModelScope.launch { saveOptions(color1.value, fondo.value) }
            }
        }
    }

    private suspend fun saveOptions(color1: Color, fondo: Int) {
        // Extraemos los componentes de color ARGB
        val argb = color1.toArgb()
        val color1Int = Color(android.graphics.Color.red(argb), android.graphics.Color.green(argb), android.graphics.Color.blue(argb))

        val options = Options(color1Int.red, color1Int.green, color1Int.blue, fondo)
        // Eliminamos la entrada existente en la base de datos (si existe)
        database.optionsDao().deleteAllOptions()
        database.optionsDao().insertOptions(options)
    }


    private suspend fun getOptions(): Options? {
        return database.optionsDao().getOptions()
    }
}
