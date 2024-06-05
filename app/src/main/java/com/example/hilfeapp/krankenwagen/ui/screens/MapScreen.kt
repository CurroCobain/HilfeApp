package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Geocoder
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
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
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.data.Urgencia
import com.example.hilfeapp.krankenwagen.navigation.Routes
import com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import kotlinx.coroutines.launch

/**
 * Función composable que muestra la pantalla del mapa.
 *
 * @param navController Controlador de navegación.
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param optionsViewModel ViewModel que maneja las opciones de la aplicación.
 * @param doctorViewModel ViewModel que maneja la lógica relacionada con el doctor.
 * @param dataBaseViewModel ViewModel que maneja la lógica relacionada con la base de datos.
 */
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MapScreen(
    navController: NavController,
    locationViewModel: LocationViewModel,
    optionsViewModel: OptionsViewModel,
    doctorViewModel: DoctorViewModel,
    dataBaseViewModel: DataBaseViewModel
) {
    val context = LocalContext.current // Contexto de la app
    val listUrgencias by dataBaseViewModel.listEr.collectAsState() // Listado de urgencias
    val miUrgencia by dataBaseViewModel.miUrgencia.collectAsState() // Urgencia actual del sistema
    val updated by dataBaseViewModel.updated.collectAsState() // Contador que ayuda a reconstruir la pantalla

    // Estado para controlar si el mensaje ya se ha mostrado
    val showToast by locationViewModel.showToast.collectAsState()

    // Muestra un mensaje si hay urgencias pendientes y si aún no se ha mostrado el Toast
    if (showToast) {
        if (listUrgencias.isNotEmpty()) {
            Toast.makeText(context, "Hay urgencias pendientes", Toast.LENGTH_SHORT).show()
        }
        if (miUrgencia == null) {
            Toast.makeText(context, "No tiene urgencias asignadas", Toast.LENGTH_SHORT).show()
        }
        locationViewModel.setToast()
    }

    val editUrgencia by locationViewModel.editUrg.collectAsState() // Booleano para mostrar el diálogo con la información de la urgencia
    val drawerState =
        rememberDrawerState(initialValue = DrawerValue.Closed) // Despliega o cierra el menú lateral
    val locationText by locationViewModel.addressText.collectAsState() // Dirección de la urgencia en formato texto
    val userLocation by locationViewModel.userLocation.collectAsState() // Coordenadas del usuario actual
    // Si tenemos urgencia en curso se asigna la localización de la misma la la variable del viewModel que la gestiona
    if (miUrgencia != null) {
        locationViewModel.setUrLocation(miUrgencia!!.location)
        // Si no tenemos urgencia asignada se modifica el valor que gestiona su localización para evitar el null
    } else {
        locationViewModel.setUrLocation(userLocation!!)
    }
    // Se actualiza la localización de la ambulancia del usuario
    dataBaseViewModel.setAmbLoc(userLocation!!)
    // Localización de la urgencia actual
    val urgencyLocation by locationViewModel.urgencyLocation.collectAsState()
    // Geocoder para la gestión d coordenadas y direcciones
    val geocoder = Geocoder(context)
    //Booleano para cambiar el foco en el mapa
    val focus by locationViewModel.focusErAmb.collectAsState()
    // Opción de color de la app
    val color1 by optionsViewModel.color1.collectAsState()
    //Opción de fondo de la app
    val fondo by optionsViewModel.fondo.collectAsState()
    //Mensaje del sistema
    val message by dataBaseViewModel.message.collectAsState()
    // Posición del mapa
    val cameraPositionState by locationViewModel.cameraPosition.collectAsState()

    // Ayuda para reconstruir la pantalla No visible en app
    Text(text = updated.toString(), color = Color.Transparent)
    // ModalNavigationDrawer para el menú de navegación
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController, optionsViewModel, doctorViewModel)
            }
        })
    {
        val scope = rememberCoroutineScope()
        // Scaffold principal de la pantalla que incluye el botón para desplegar el menú lateral
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier.padding(bottom = 20.dp),
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
            // Contenido de la app
            MapContent(
                context = context,
                locationText = locationText,
                userLocation = userLocation,
                urgencyLocation = urgencyLocation!!,
                locationViewModel = locationViewModel,
                geocoder = geocoder,
                focus = focus,
                fondo = fondo,
                dataBaseViewModel,
                listUrgencias,
                miUrgencia,
                editUrgencia,
                navController,
                color1,
                message,
                cameraPositionState
            )
        }
    }
}

/**
 * Función composable que muestra el contenido del mapa.
 *
 * @param context Contexto de la aplicación.
 * @param locationText Texto de la ubicación.
 * @param userLocation Ubicación del usuario.
 * @param urgencyLocation Ubicación de la urgencia.
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param geocoder Geocoder para convertir coordenadas en direcciones.
 * @param focus Indica si el foco está en la ambulancia o en la urgencia.
 * @param fondo ID del recurso de la imagen de fondo.
 * @param dataBaseViewModel ViewModel que maneja la lógica relacionada con la base de datos.
 * @param listUrgencias Lista de urgencias.
 * @param miUrgencia Urgencia actual.
 * @param editUrgencia Indica si se está editando una urgencia.
 * @param navController Controlador de navegación.
 * @param color Color del botón.
 * @param message Mensaje a mostrar.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MapContent(
    context: Context,
    locationText: String,
    userLocation: LatLng?,
    urgencyLocation: LatLng,
    locationViewModel: LocationViewModel,
    geocoder: Geocoder,
    focus: Boolean,
    fondo: Int,
    dataBaseViewModel: DataBaseViewModel,
    listUrgencias: MutableList<Urgencia>,
    miUrgencia: Urgencia?,
    editUrgencia: Boolean,
    navController: NavController,
    color: Color,
    message: String,
    cameraPositionState: CameraPositionState
) {
    // Box principal ayuda para conformar el fondo
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        // Imagen de fondo
        Image(
            painter = painterResource(id = fondo),
            contentDescription = "Fondo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        // Columna principal
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            )
            {
                // Mapa interactivo
                MyMap(
                    geocoder,
                    context,
                    locationViewModel,
                    locationText,
                    userLocation,
                    urgencyLocation,
                    focus,
                    dataBaseViewModel,
                    listUrgencias,
                    miUrgencia,
                    editUrgencia,
                    navController,
                    color,
                    message,
                    cameraPositionState
                )
                Row(
                    Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Botón para alternar el foco entre la ambulancia y la urgencia
                    Button(
                        onClick = {
                            locationViewModel.alterFocus()
                        },
                        enabled = miUrgencia != null,
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp
                        )
                    ) {
                        // Texto del botón
                        Text(
                            text = if (focus) "Ir a Ambulancia" else "Ir a Emergencia",
                            fontWeight = FontWeight.ExtraBold, fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    // Botón para actualizar la lista de urgencias
                    Button(
                        onClick = {
                            dataBaseViewModel.getUrgencies {
                                dataBaseViewModel.updateMessage("Listado de urgencias actualizado")
                                locationViewModel.setToast()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp
                        )
                    )
                    {
                        // Texto del botón
                        Text(
                            text = "Actualizar lista",
                            fontWeight = FontWeight.ExtraBold, fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                }
                // Fila que muestra la dirección en formato texto
                Row(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .sizeIn(minWidth = 200.dp, minHeight = 50.dp)
                            .background(Color.White)
                    ) {
                        Text(
                            text = locationText,
                            Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

/**
 * Función composable que muestra el mapa con los marcadores y permite la interacción.
 *
 * @param geocoder Geocoder para convertir coordenadas en direcciones.
 * @param context Contexto de la aplicación.
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param locationText Texto de la ubicación.
 * @param userLocation Ubicación del usuario.
 * @param urgencyLocation Ubicación de la urgencia.
 * @param focus Indica si el foco está en la ambulancia o en la urgencia.
 * @param dataBaseViewModel ViewModel que maneja la lógica relacionada con la base de datos.
 * @param listUrgencias Lista de urgencias.
 * @param miUrgencia Urgencia actual.
 * @param editUrgencia Indica si se está editando una urgencia.
 * @param navController Controlador de navegación.
 * @param color Color del botón.
 * @param message Mensaje
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyMap(
    geocoder: Geocoder,
    context: Context,
    locationViewModel: LocationViewModel,
    locationText: String?,
    userLocation: LatLng?,
    urgencyLocation: LatLng,
    focus: Boolean,
    dataBaseViewModel: DataBaseViewModel,
    listUrgencias: MutableList<Urgencia>,
    miUrgencia: Urgencia?,
    editUrgencia: Boolean,
    navController: NavController,
    color: Color,
    message: String,
    cameraPositionState: CameraPositionState
) {
    // Implementación de google maps
    GoogleMap(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(
            isMyLocationEnabled = true,
            isTrafficEnabled = true,
            mapType = MapType.HYBRID
        )
    ) {
        // Efecto que cambia el foco del mapa entre urgencia y ambulancia, sólo funciona cuando hay urgencia activa
        LaunchedEffect(focus, userLocation, urgencyLocation) {
            val position = if (focus) {
                urgencyLocation
            } else {
                userLocation
            }
            if (position != null) {
                locationViewModel.setCameraPositionState(
                    CameraPositionState(
                        position = CameraPosition.fromLatLngZoom(position, 16f)
                    )
                )
            }
        }
        // Generamos un marcador con la ubicación del usuario y el icono de la ambulancia
        if (userLocation != null) {
            // Cargamos el icono personalizado como un Bitmap
            val iconBitmapEr: Bitmap =
                BitmapFactory.decodeResource(context.resources, R.drawable.icono)
            val iconBitmapAmb: Bitmap =
                BitmapFactory.decodeResource(context.resources, R.drawable.ambulancia)
            // Definimos el tamaño deseado para el icono (en píxeles)
            val iconWidth = 60 // Ancho deseado del icono
            val iconHeight = 100 // Altura deseada del icono
            // Escalamos el Bitmap al tamaño deseado
            val scaledIconBitmapAmb =
                Bitmap.createScaledBitmap(iconBitmapAmb, iconHeight, iconHeight, false)
            val scaledIconBitmapEr =
                Bitmap.createScaledBitmap(iconBitmapEr, iconWidth, iconHeight, false)
            // Convertimos el Bitmap escalado a un BitmapDescriptor
            val scaledIconEr = BitmapDescriptorFactory.fromBitmap(scaledIconBitmapEr)
            val scaledIconAmb = BitmapDescriptorFactory.fromBitmap(scaledIconBitmapAmb)
            // Muestra el icono de la ambulancia
            Marker(
                state = MarkerState(position = userLocation),
                snippet = locationText,
                icon = scaledIconAmb,
                onClick = {
                    locationViewModel.getAddressFromCoordinates(geocoder, userLocation)
                    dataBaseViewModel.setAmbLoc(userLocation)
                    false
                }
            )
            for (i in listUrgencias) {
                // Mostramos un marcador que al pulsarlo nos muestra la información de la urgencia
                Marker(
                    state = MarkerState(position = i.location),
                    snippet = locationText,
                    icon = scaledIconEr,
                    onClick = {
                        locationViewModel.getAddressFromCoordinates(geocoder, i.location)
                        dataBaseViewModel.setUrg(i)
                        locationViewModel.setUrLocation(i.location)
                        locationViewModel.openCloseEditUrg()
                        false
                    }
                )

            }
            // Se muestra el diálogo de edición de la urgencia al pulsar sobre el icono de la misma
            if (editUrgencia) {
                locationViewModel.checkInitializated(miUrgencia!!)
                UrgenciaDialog(
                    urgencia = miUrgencia,
                    locationViewModel = locationViewModel,
                    // Al pulsar el botón de "iniciar aviso" se llama a la función "initUrg" del viewModel
                    onIniciarAvisoClick = {
                        dataBaseViewModel.setUrg(miUrgencia)
                        locationViewModel.setUrLocation(miUrgencia.location)
                        // Si no hemos indicado la ambulancia en la que vamos se lanza mensaje de error y se redirige al usuario a la pantalla de opciones
                        if (dataBaseViewModel.myAmb.value != "No definida") {
                            dataBaseViewModel.intiUrg()
                            locationViewModel.getUserLocation {
                                dataBaseViewModel.setAmbLoc(userLocation)
                            }
                            Toast.makeText(context, "Aviso iniciado", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(
                                context,
                                "Debe seleccionar una ambulancia",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            navController.navigate(Routes.PantallaOptions.route)
                        }
                        locationViewModel.openCloseEditUrg()
                    },
                    // Al pulsar el botón de "finalizar aviso" se llama a la función "finishUrg" del viewModel
                    onFinalizarAvisoClick = {
                        dataBaseViewModel.finishUrg {
                            dataBaseViewModel.setNull {
                                dataBaseViewModel.getUrgencies {
                                    locationViewModel.setToast()
                                    dataBaseViewModel.setSize()
                                }
                            }
                            locationViewModel.getUserLocation {
                                dataBaseViewModel.setAmbLoc(userLocation)
                            }
                        }
                        locationViewModel.openCloseEditUrg()
                        Toast.makeText(context, "Aviso finalizado", Toast.LENGTH_LONG).show()
                    },
                    color = color
                )
            }
        }
    }
}