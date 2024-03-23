package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.hilfeapp.krankenwagen.ui.viewModels.CallViewModel

@Composable
fun CallScreen(callViewModel: CallViewModel) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
    }

}