package com.example.hilfeapp.krankenwagen.ui.screens

import CallViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MenuLateral(){
    val context = LocalContext.current
    val callViewModel = CallViewModel(context)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val resultText by callViewModel.incomingText.collectAsState()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet { /* Drawer content */ }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Mostrar menú") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
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
            // Screen content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Button(
                    onClick = {
                        callViewModel.makePhoneCall()
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Llamar")
                }
                Button(
                    onClick = {
                        callViewModel.startTextToSpeech("Esto es una prueba")
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Lanzar texto")
                }
                Button(
                    onClick = {
                        callViewModel.startSpeechToText()
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Iniciar grabación")
                }
                Button(
                    onClick = {
                        callViewModel.stopSpeechToText()
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Detener grabación")
                }
                Text(text = resultText,
                    Modifier
                        .border(width = 2.dp, color = Color.Black)
                        .wrapContentSize())
            }
            //TestCallScreen {}
        }
    }
}