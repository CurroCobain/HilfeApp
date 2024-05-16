package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Geocoder
import android.os.Build
import android.os.Message
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.material3.Icon
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
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

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
    val context = LocalContext.current
    val listUrgencias by dataBaseViewModel.listEr.collectAsState()

    if (listUrgencias.size != 0)
        Toast.makeText(
            context,
            "Hay urgencias pendientes",
            Toast.LENGTH_SHORT
        ).show()

    val miUrgencia by dataBaseViewModel.miUrgencia.collectAsState()
    val editUrgencia by locationViewModel.editUrg.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val locationText by locationViewModel.addressText.collectAsState()
    val userLocation by locationViewModel.userLocation.collectAsState()
    locationViewModel.setUrLocation(userLocation!!)
    dataBaseViewModel.setAmbLoc(userLocation!!)
    val urgencyLocation by locationViewModel.urgencyLocation.collectAsState()
    val geocoder = Geocoder(context)
    val focus by locationViewModel.focusErAmb.collectAsState()
    val color1 by optionsViewModel.color1.collectAsState()
    val fondo by optionsViewModel.fondo.collectAsState()
    val message by dataBaseViewModel.message.collectAsState()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController, optionsViewModel, doctorViewModel)
            }
        })
    {
        val scope = rememberCoroutineScope()
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
            )
        }
    }
}

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
) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = fondo),
            contentDescription = "Fondo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            )
            {
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
                )
                Row(
                    Modifier.padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            if (miUrgencia != null) {
                                locationViewModel.alterFocus()
                            } else if (focus) {
                                locationViewModel.alterFocus()
                            } else {
                                Toast.makeText(
                                    context,
                                    "No tiene urgencias asignadas",
                                    Toast.LENGTH_LONG
                                ).show()
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
                        Text(
                            text = if (focus) "Ir a Ambulancia" else "Ir a Emergencia",
                            fontWeight = FontWeight.ExtraBold, fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = {
                            dataBaseViewModel.getUrgencies {
                                    Toast.makeText(
                                        context,
                                        "Listado de urgencias actualizado",
                                        Toast.LENGTH_SHORT
                                    ).show()
                            }
                            dataBaseViewModel.updateMessage("")
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
                        Text(
                            text = "Actualizar lista",
                            fontWeight = FontWeight.ExtraBold, fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                }
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
) {
    val cameraPositionState =
        if (focus) rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(urgencyLocation, 16f)
        }
        else rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(userLocation!!, 16f)
        }

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
            if (editUrgencia) {
                UrgenciaDialog(
                    urgencia = miUrgencia!!,
                    locationViewModel = locationViewModel,
                    onIniciarAvisoClick = {
                        if (dataBaseViewModel.myAmb.value != "No definida") {
                            dataBaseViewModel.intiUrg()
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
                    onFinalizarAvisoClick = {
                        dataBaseViewModel.finishUrg()
                        locationViewModel.openCloseEditUrg()
                        Toast.makeText(context, "Aviso finalizado", Toast.LENGTH_LONG).show()
                        if (!focus) {
                            locationViewModel.alterFocus()
                        }
                        dataBaseViewModel.getUrgencies { }
                    },
                    color = color
                )
            }
        }
    }
}
