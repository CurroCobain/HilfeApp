package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.hilfeapp.krankenwagen.data.Urgencia
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel


@Composable
fun UrgenciaDialog(
    urgencia: Urgencia,
    locationViewModel: LocationViewModel,
    onIniciarAvisoClick: () -> Unit,
    onFinalizarAvisoClick: () -> Unit,
    color: Color,
) {
    Dialog(
        onDismissRequest = { locationViewModel.openCloseEditUrg() },
        content = {
            Surface(
                modifier = Modifier.width(300.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Detalles de la urgencia", style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Nombre: ${urgencia.name}")
                    Text("Edad: ${urgencia.age}")
                    Text("Prioridad: ${urgencia.priority}")
                    Text("Fecha: ${urgencia.date}")
                    Text("Descripción: ${urgencia.issues}")
                    Text("Ambulancia: ${urgencia.ambulance}")
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { onIniciarAvisoClick() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(color),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(2.dp, Color.Black)
                        ) {
                            Text("Iniciar aviso")
                        }
                        Button(
                            onClick = { onFinalizarAvisoClick() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(color),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(2.dp, Color.Black)
                        ) {
                            Text("Finalizar aviso")
                        }
                    }
                }
            }
        }
    )
}

