package com.example.hilfeapp.krankenwagen.ui.screens

import CallViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Composable principal de la página de llamada
 */
@Composable
fun CallScreen(
    callViewModel: CallViewModel,
    navController: NavController
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController)
            }
        })
    {
        Llamada(callViewModel, drawerState)
    }
}

/**
 * Composable que muestra el contenido de la página de llamada
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Llamada(
    callViewModel: CallViewModel,
    drawerState: DrawerState)
{
    // ---------------------- Variables de la screen ---------------------------------------------
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val resultText by callViewModel.incomingText.collectAsState()
    val message by callViewModel.callText.collectAsState()
    var button1Color by remember { mutableStateOf(Color.Red) }
    var button2Color by remember { mutableStateOf(Color.Red) }
    var button3Color by remember { mutableStateOf(Color.Red) }
    var button4Color by remember { mutableStateOf(Color.Red) }

    // ------------------------------ Scaffold del menú desplegable --------------------------------
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
    ) {// -------------------- Columna principal ------------------------------------
        // Screen content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // ------------------------------ Textfield para TTS ---------------------------------------
            TextField(
                value = message,
                onValueChange = { newValue ->
                    callViewModel.addCallText(newValue)
                },
                label = { Text(text = "Introduce el mensaje que quieres envia") },
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.2f),
            )
            // ---------------------- Efecto del botón de llamada ---------------------------------
            ButtonColorEffect(button1Color) { newColor ->
                button1Color = newColor
            }
            // ----------------------- Botón de llamada ------------------------------------------
            Button(
                onClick = {
                    button1Color = Color.Green
                    callViewModel.makePhoneCall()
                },
                colors = ButtonDefaults.buttonColors(button1Color)
            ) {
                Text(text = "Llamar")
            }
            // ---------------------- Efecto del botón de TTS ---------------------------------
            ButtonColorEffect(button2Color) { newColor ->
                button2Color = newColor
            }
            // -------------------------------- Botón de TTS ---------------------------------
            Button(
                onClick = {
                    button2Color = Color.Green
                    callViewModel.startTextToSpeech(message)
                },
                colors = ButtonDefaults.buttonColors(button2Color)
            ) {
                Text(text = "Lanzar texto")
            }
            // ---------------------- Efecto del botón de STT ---------------------------------
            ButtonColorEffect(button3Color) { newColor ->
                button3Color = newColor
            }
            // -------------------------------- Botón de STT ---------------------------------
            Button(
                onClick = {
                    button3Color = Color.Green
                    callViewModel.startSpeechToText()
                },
                colors = ButtonDefaults.buttonColors(button3Color),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Grabar mensaje")
            }
            // ---------------------- Efecto del botón de borrar ---------------------------------
            ButtonColorEffect(button4Color) { newColor ->
                button4Color = newColor
            }
            // ------------------------- Botón de borrar campos ---------------------------------
            Button(
                onClick = {
                    button4Color = Color.Green
                    callViewModel.removeCallText()
                    callViewModel.deleteIncomingText()
                },
                colors = ButtonDefaults.buttonColors(button4Color)
            ) {
                Text(text = "Borrar resultados")
            }
            Text(text = resultText,
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
        }
    }
}

/**
 * Funcion que realiza el efecto de cambio de color de los botones al ser pulsados
 */
@Composable
fun ButtonColorEffect(color: Color, onColorChange: (Color) -> Unit) {
    LaunchedEffect(color) {
        if (color == Color.Green) {
            delay(200)
            onColorChange(Color.Red)
        }
    }
}
