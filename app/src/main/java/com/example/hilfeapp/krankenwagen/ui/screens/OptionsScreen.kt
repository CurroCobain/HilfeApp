package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.data.Ambulance
import com.example.hilfeapp.krankenwagen.data.Hospital
import com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OptionsScreen(
    navController: NavController,
    optionsViewModel: OptionsViewModel,
    dataBaseViewModel: DataBaseViewModel,
    doctorViewModel: DoctorViewModel
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val color1 by optionsViewModel.color1.collectAsState()
    val fondo by optionsViewModel.fondo.collectAsState()
    val listCounty = dataBaseViewModel.tempCounty
    val listHosp by dataBaseViewModel.listHospitals.collectAsState()
    val listAmbs by dataBaseViewModel.listAmbulancias.collectAsState()
    val selectedCounty by dataBaseViewModel.provinciaFiltrar.collectAsState()
    val selectedHosp by dataBaseViewModel.hospitalFiltrar.collectAsState()
    val myAmbulance by dataBaseViewModel.myAmb.collectAsState()


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
            ContenidoOpt(
                fondo,
                optionsViewModel,
                dataBaseViewModel,
                selectedHosp,
                selectedCounty,
                listCounty,
                listHosp,
                listAmbs,
                myAmbulance
            )
        }
    }
}

@Composable
fun ContenidoOpt(
    fondo: Int,
    optionsViewModel: OptionsViewModel,
    dataBaseViewModel: DataBaseViewModel,
    selectedHosp: Hospital,
    selectedCounty: String,
    listCounty: List<String>,
    listHosp: MutableList<Hospital>,
    listAmbs: MutableList<Ambulance>,
    myAmbulance: Ambulance
) {
    var expandedHosp by remember { mutableStateOf(false) }
    var expandedCounty by remember { mutableStateOf(false) }
    var expandedAmb by remember { mutableStateOf(false) }

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
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Elija el tema",
                    modifier = Modifier.padding(65.dp),
                    fontSize = 40.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fondo_rojo),
                    contentDescription = "rojo",
                    modifier = Modifier
                        .clickable {
                            optionsViewModel.setTheme(0)
                        }
                        .width(80.dp)
                        .height(160.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.fondo_verde),
                    contentDescription = "verde",
                    modifier = Modifier
                        .clickable {
                            optionsViewModel.setTheme(1)
                        }
                        .width(80.dp)
                        .height(160.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.fondo_azul),
                    contentDescription = "azul",
                    modifier = Modifier
                        .clickable {
                            optionsViewModel.setTheme(2)
                        }
                        .width(80.dp)
                        .height(160.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )

            }
            Spacer(modifier = Modifier.padding(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Texto elige provincia
                Box(modifier = Modifier.clip(RoundedCornerShape(4.dp))) {
                    Text(text = " Seleccione \n  provincia ",
                        modifier = Modifier
                            .clickable { expandedCounty = true }
                            .background(color = Color.White),
                        fontWeight = FontWeight.Bold
                    )
                }
                // Texto elige hospital
                Box(modifier = Modifier.clip(RoundedCornerShape(4.dp))) {
                    Text(text = " Seleccione \n   hospital ",
                        modifier = Modifier
                            .clickable {
                                dataBaseViewModel.getHosp(selectedCounty) {
                                    expandedHosp = true
                                }
                            }
                            .background(color = Color.White),
                        fontWeight = FontWeight.Bold
                    )
                }
                // Texto elige ambulancia
                Box(modifier = Modifier.clip(RoundedCornerShape(4.dp))) {
                    Text(text = " Seleccione \n ambulancia ",
                        modifier = Modifier
                            .clickable {
                                dataBaseViewModel.getAmb(selectedHosp.id) {
                                    expandedAmb = true
                                }
                            }
                            .background(color = Color.White),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Elije provincia
                Column(modifier = Modifier.clickable(onClick = { expandedCounty = true })) {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color.White)
                        .align(Alignment.CenterHorizontally)) {
                        Text(
                            text = " $selectedCounty ".uppercase(), // Mostrar la provincia actual
                            modifier = Modifier
                                .padding(8.dp)
                                .sizeIn(minWidth = 100.dp, minHeight = 30.dp),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    DropdownMenu(
                        expanded = expandedCounty,
                        onDismissRequest = {
                            expandedCounty = false
                        }, // Cierra el menú al hacer clic fuera de él
                        modifier = Modifier.width(IntrinsicSize.Max)
                    ) {
                        listCounty.forEach { county ->
                            DropdownMenuItem(
                                text = { Text(text = county) },
                                onClick = {
                                    dataBaseViewModel.setCounty(county) {
                                        expandedCounty =
                                            false // Actualiza el estado de expansión al hacer clic en un elemento del menú
                                    }
                                })
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Elije hospital
                Column(modifier = Modifier.clickable(onClick = { expandedHosp = true })) {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color.White)
                        .align(Alignment.CenterHorizontally)){
                        Text(
                            text = " ${selectedHosp.name} ".uppercase(), // Mostrar el hospital actual
                            modifier = Modifier
                                .padding(8.dp),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    DropdownMenu(
                        expanded = expandedHosp,
                        onDismissRequest = {
                            expandedHosp = false
                        }, // Cierra el menú al hacer clic fuera de él
                        modifier = Modifier.width(IntrinsicSize.Max)
                    ) {
                        listHosp.forEach { hosp ->
                            DropdownMenuItem(
                                text = { Text(text = hosp.name) },
                                onClick = {
                                    dataBaseViewModel.setHosp(hosp)
                                    expandedHosp = false
                                }
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                //Elije ambulancia
                Column(modifier = Modifier.clickable(onClick = { expandedAmb = true })) {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color.White)
                        .align(Alignment.CenterHorizontally)){
                        Text(
                            text = " ${myAmbulance.plate} ", // Mostrar ambulancia actual
                            modifier = Modifier
                                .padding(8.dp),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    DropdownMenu(
                        expanded = expandedAmb,
                        onDismissRequest = {
                            expandedAmb = false
                        }, // Cierra el menú al hacer clic fuera de él
                        modifier = Modifier.width(IntrinsicSize.Max)
                    ) {
                        listAmbs.forEach { amb ->
                            DropdownMenuItem(
                                text = { Text(text = amb.plate) },
                                onClick = {
                                    dataBaseViewModel.setAmb(amb)
                                    expandedAmb =
                                        false // Actualiza el estado de expansión al hacer clic en un elemento del menú
                                })
                        }
                    }
                }
            }
        }
    }
}