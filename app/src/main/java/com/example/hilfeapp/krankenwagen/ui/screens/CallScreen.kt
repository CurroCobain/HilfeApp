package com.example.hilfeapp.krankenwagen.ui.screens

import CallViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CallScreen(callViewModel: CallViewModel) {
    val context = LocalContext.current
    val resultText by callViewModel.incomingText.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MenuLateral()
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
}

@Preview
@Composable
fun PreviewCallScreen (){
    val context = LocalContext.current
    val callViewModel = CallViewModel(context)
    CallScreen(callViewModel = callViewModel)
}