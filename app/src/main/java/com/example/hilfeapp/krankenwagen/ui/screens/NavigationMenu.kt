
package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.navigation.Routes
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Composable que muestra el contenido del menú de navegación.
 *
 * @param navController Controlador de navegación.
 * @param optionsViewModel ViewModel que maneja las opciones de la aplicación.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 */
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NavigationMenu (
    navController: NavController,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel
) {
    // Estado del nombre del doctor
    val nombeDoc by doctorViewModel.nombreDoc.collectAsState()
    // Estado para el color de cada fila del menú
    var row1Color by remember { mutableStateOf(Color.Transparent) }
    var row2Color by remember { mutableStateOf(Color.Transparent) }
    var row3Color by remember { mutableStateOf(Color.Transparent) }
    var row4Color by remember { mutableStateOf(Color.Transparent) }
    // Estado del color de la aplicación
    val color1 by optionsViewModel.color1.collectAsState()
    // Estado para salir de la aplicación
    var exit by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    // Estado del usuario registrado
    val userRegistered by doctorViewModel.userRegistered.collectAsState()
    val context = LocalContext.current

    // Si se solicita salir, muestra una pantalla de despedida y sale de la aplicación
    if (exit) {
        Despedida(color1)
        coroutineScope.launch {
            delay(3000)
            optionsViewModel.exit()
        }
    } else {
        // Contenido del menú
        Column(
            Modifier
                .fillMaxWidth(0.8f)
                .background(color1)
        ) {
            // Banner superior
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Text(
                    text = "Menú principal",
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 30.dp, top = 15.dp)
                )
            }
            // Nombre de usuario activo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Text(
                    text = "Usuario activo: Dr $nombeDoc",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 30.dp, top = 15.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp)
            ) {
                Spacer(modifier = Modifier.padding(50.dp))

                // Efecto de la línea de configuración
                RowColorEffect(row1Color) { newColor ->
                    row1Color = newColor
                }
                // Configuración
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = row1Color)
                        .clickable {
                            row1Color = Color.White
                            if(userRegistered){
                                navController.navigate(Routes.PantallaOptions.route)
                            }else{
                                Toast.makeText(context,
                                    "Por favor inicie sesión",
                                    Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                ) {
                    // Icono de configuración
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "Android Icon",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    // Texto de configuración
                    Text(
                        text = "Configuración",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))

                // Efecto de la línea del mapa
                RowColorEffect(row2Color) { newColor ->
                    row2Color = newColor
                }
                // Mapa
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = row2Color)
                        .clickable {
                            row2Color = Color.White
                            if (userRegistered) {
                                // Verifica si ya estás en la pantalla de mapa para evitar errores en la app
                                if (navController.currentBackStackEntry?.destination?.route != Routes.PantallaMap.route) {
                                    navController.navigate(Routes.PantallaMap.route)
                                } else {
                                    Toast.makeText(context, "Ya estás en la pantalla de Mapa", Toast.LENGTH_LONG).show()
                                }
                            } else {
                                Toast.makeText(context, "Por favor inicie sesión", Toast.LENGTH_LONG).show()
                            }
                        }
                ) {
                    // Icono de mapa
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Android Icon",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    // Texto de mapa
                    Text(
                        text = "Mapa",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                // Efecto de la línea de usuario
                RowColorEffect(row3Color) { newColor ->
                    row3Color = newColor
                }
                // Usuario
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = row3Color)
                        .clickable {
                            row3Color = Color.White
                            if(userRegistered){
                                navController.navigate(Routes.PantallaUser.route)
                            }else{
                                Toast.makeText(context,
                                    "Por favor inicie sesión",
                                    Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                ) {
                    // Icono de usuario
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Android Icon",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    // Texto de usuario
                    Text(
                        text = "Usuario",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))

                // Efecto de la línea de salida
                RowColorEffect(row4Color) { newColor ->
                    row4Color = newColor
                }
                // Salir
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = row4Color)
                        .clickable {
                            row4Color = Color.White
                            exit = true
                        }
                ) {
                    // Icono de salir
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Android Icon",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    // Texto de salir
                    Text(
                        text = "Salir",
                        fontSize = 25.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

/**
 * Función que realiza el efecto de cambio de color de los botones al ser pulsados.
 *
 * @param color Color actual de la fila.
 * @param onColorChange Función para cambiar el color.
 */
@Composable
fun RowColorEffect(color: Color, onColorChange: (Color) -> Unit) {
    LaunchedEffect(color) {
        if (color == Color.White) {
            delay(200)
            onColorChange(Color.Transparent)
        }
    }
}

/**
 * Composable que muestra un gif al cerrar la app.
 *
 * @param color1 Color de fondo.
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Despedida(
    color1: Color
){
    Column(Modifier.fillMaxSize()
        .background(color = color1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        // Composable para mostrar una imagen animada
        GlideImage(
            model = R.drawable.despedida,
            contentDescription = "Gif de despedida"
        )
    }
}
