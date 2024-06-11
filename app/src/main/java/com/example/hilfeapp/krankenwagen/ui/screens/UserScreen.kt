package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.navigation.Routes
import com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.launch


/**
 * Composable que representa la pantalla de usuario.
 *
 * @param navController Controlador de navegación.
 * @param optionsViewModel ViewModel que maneja las opciones de la aplicación.
 * @param dataBaseViewModel ViewModel que maneja la base de datos.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 */
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(
    navController: NavController,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel
) {
    // Estado del drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // Estado del color de la aplicación
    val color1 by optionsViewModel.color1.collectAsState()
    // Estado del fondo
    val color2 by optionsViewModel.color2.collectAsState()
    // Estado del mail
    val mailDoc by doctorViewModel.nuevoMail.collectAsState()
    //Estado de la contraseña
    val passDoc by doctorViewModel.nuevoPass.collectAsState()
    val context = LocalContext.current
    // Mesnaje del sistema
    val message by doctorViewModel.sesionMessage.collectAsState()
    // Booleano para comprobar el inicio de sesión
    val sesionInit by doctorViewModel.userRegistered.collectAsState()
    // Matrícula de la ambulancia actual
    val myAmb by dataBaseViewModel.myAmb.collectAsState()

    // Drawer de navegación
    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController, optionsViewModel, doctorViewModel)
            }
        })
    {
        val scope = rememberCoroutineScope()
        // Sacaffold para la pantalla de usuario
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier.padding(bottom = 20.dp)
                        .border(
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(2.dp, Color.Black)),
                    containerColor = color1,
                    text = { Text("Menú", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp) },
                    icon = { Icon(Icons.Filled.Menu, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) {
            // Contenido de la pantalla usuario
            ContenidoUser(
                color1,
                color2,
                doctorViewModel,
                dataBaseViewModel,
                mailDoc,
                passDoc,
                context,
                message,
                navController,
                sesionInit,
                myAmb
            )
        }
    }
}

/**
 * Composable que representa el contenido de la pantalla de usuario.
 *
 * @param fondo Fondo de la pantalla de usuario.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 * @param dataBaseViewModel ViewModel que maneja la base de datos.
 * @param mailDoc Correo electrónico del doctor.
 * @param passDoc Contraseña del doctor.
 * @param context Contexto de la aplicación.
 * @param message Mensaje de error o confirmación.
 * @param navController Controlador de navegación.
 * @param sesionInit Indica si la sesión está iniciada o no.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContenidoUser(
    color1: Color,
    color2: Color,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel,
    mailDoc: String,
    passDoc: String,
    context: Context,
    message: String,
    navController: NavController,
    sesionInit: Boolean,
    myAmb: String
) {
    // Contenedor principal
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        color1,
                        color2
                    ),
                    start = Offset(0f, 0f),
                    end = Offset.Infinite
                )
            )
    ) {
        // Columna para organizar los elementos de la pantalla de usuario
        Column(
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxSize()
        )
        {
            // Mensaje de bienvenida o inicio de sesión
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = if(!sesionInit) "Inicie sesión por favor"
                    else "Bienvenido Dr",
                    fontSize = 30.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.padding(40.dp))
            // Campo de texto para el correo electrónico
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                TextField(
                    value = mailDoc,
                    onValueChange = { newValue ->
                        doctorViewModel.cambiaMail(newValue)
                    },
                    label = { Text(text = "Mail") },
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            // Campo de texto para la contraseña
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                TextField(
                    value = passDoc,
                    onValueChange = { newValue ->
                        doctorViewModel.cambiaPass(newValue)
                    },
                    label = { Text(text = "Password") },
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            // Botón de confirmar inicio de sesión
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Button(
                    onClick = {
                        // Inicia la sesión y muestra un mensaje de confirmación
                        doctorViewModel.sesionInit {
                            doctorViewModel.trueFalseSesionInit()
                            navController.navigate(Routes.PantallaOptions.route)
                            doctorViewModel.cambiaNombre()
                            Toast.makeText(
                                context,
                                "Sesión inicada correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            doctorViewModel.setMessage("")
                        }
                        dataBaseViewModel.getUrgencies {}
                    },
                    enabled = !sesionInit,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black)
                )
                {
                    Text(
                        text = stringResource(R.string.confirmar),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                // Botón para borrar los datos
                Button(
                    onClick = {
                        // Borra los datos del correo electrónico y la contraseña
                        doctorViewModel.cambiaMail("")
                        doctorViewModel.cambiaPass("")
                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black)
                ) {
                    Text(
                        text = "Borrar todo",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(16.dp))
            // Botón para cerrar sesión
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Button(
                    onClick = {
                        // Si hemos asignado ambulancia hay que resetarla antes de cerrar sesión
                        if(myAmb != "No definida"){
                            dataBaseViewModel.unSetAmb {
                                // Cierra la sesión y muestra un mensaje de confirmación
                                doctorViewModel.cerrarSesion {
                                    doctorViewModel.trueFalseSesionInit()
                                    doctorViewModel.cambiaNombre()
                                    Toast.makeText(
                                        context,
                                        "Sesión cerrada",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } else {
                            // Si no hay ambulancia asignada cerramos sesión
                            doctorViewModel.cerrarSesion {
                                doctorViewModel.cambiaNombre()
                                Toast.makeText(
                                    context,
                                    "Sesión cerrada",
                                    Toast.LENGTH_SHORT
                                ).show()
                                doctorViewModel.trueFalseSesionInit()
                            }
                        }
                    },
                    enabled = sesionInit,
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(6.dp),
                    border = BorderStroke(2.dp, Color.Black)
                )
                {
                    Text(
                        text = "Cerrar sesión",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            // Mensaje de error o confirmación
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Text(
                    // Muestra el mensaje del sistema
                    text = message,
                    color = Color.White
                )
            }
        }
    }
}

