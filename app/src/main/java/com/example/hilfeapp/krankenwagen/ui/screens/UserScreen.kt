package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(navController: NavController, optionsViewModel: OptionsViewModel, doctorViewModel: DoctorViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val color1 by optionsViewModel.color1.collectAsState()
    val fondo by optionsViewModel.fondo.collectAsState()
    val mailDoc by doctorViewModel.nuevoMail.collectAsState()
    val passDoc by doctorViewModel.nuevoPass.collectAsState()
    val nombeDoc by doctorViewModel.nombreDoc.collectAsState()
    val context = LocalContext.current
    val message by doctorViewModel.sesionMessage.collectAsState()


    ModalNavigationDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet{
                NavigationMenu(navController, optionsViewModel)
            }
        })
    {
        val scope = rememberCoroutineScope()
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier.padding(bottom = 20.dp),
                    containerColor = color1,
                    text = { Text("Menú") },
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
            ContenidoUser(
                fondo,
                doctorViewModel,
                mailDoc,
                passDoc,
                nombeDoc,
                context,
                message
                )
        }
    }
}

@Composable
fun ContenidoUser(
    fondo: Int,
    doctorViewModel: DoctorViewModel,
    mailDoc: String,
    passDoc: String,
    nombreDoc: String,
    context: Context,
    message: String
    ){
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
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxSize()
        )
        {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                Text(text = "Inicie sesión por favor",
                    fontSize = 30.sp)
            }

            Spacer(modifier = Modifier.padding(40.dp))
            // ------------------------ TextField mail -----------------------------
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                TextField(
                    value = mailDoc,
                    onValueChange = { newValue ->
                        doctorViewModel.cambiaMail(newValue)
                    },
                    label = { Text(text = "Mail") },
                    modifier = Modifier.border(width = 2.dp, color = Color.Black)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            // ------------------------ TextField password -----------------------------
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                TextField(
                    value = passDoc,
                    onValueChange = { newValue ->
                        doctorViewModel.cambiaPass(newValue)
                    },
                    label = { Text(text = "Password") },
                    modifier = Modifier.border(width = 2.dp, color = Color.Black)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            // --------------------- Botón confirmar --------------------------------
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Button(
                    onClick = {
                        // Se lanza sesionÍnit y si finaliza correctamente se indica mediante un Toast
                        doctorViewModel.sesionInit {
                            // sesionViewModel.getUser()
                            Toast.makeText(
                                context,
                                "Sesión iniciada correctamente",
                                Toast.LENGTH_SHORT
                            ).show()
                            // sesionViewModel.setMessage("")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color(74, 121, 66))
                )
                {
                    Text(text = stringResource(R.string.confirmar))
                }
                Spacer(modifier = Modifier.padding(20.dp))
                // ------------------------ Botón volver a registro ------------------------
                Button(
                    onClick = {
                        // Cambia al modo de registro de usuarios
                    },
                    colors = ButtonDefaults.buttonColors(Color(233, 85, 85))
                )
                {
                    Text(text = "Volver")
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            // Mensaje que aparece si hay error al iniciar sesión --------------------------
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Text(
                    // Mensaje del sistema
                    text = message,
                    color = Color.Red
                )
            }
        }
    }
}


