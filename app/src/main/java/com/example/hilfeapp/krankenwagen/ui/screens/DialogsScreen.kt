package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
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
import com.google.firebase.Timestamp
import java.text.SimpleDateFormat

/**
 * Función composable que muestra un cuadro de diálogo con los detalles de una urgencia.
 *
 * @param urgencia Objeto que contiene los detalles de la urgencia.
 * @param locationViewModel ViewModel que maneja la lógica relacionada con la ubicación.
 * @param onIniciarAvisoClick Función lambda que se ejecuta al hacer clic en el botón "Iniciar aviso".
 * @param onFinalizarAvisoClick Función lambda que se ejecuta al hacer clic en el botón "Finalizar aviso".
 * @param color Color del botón de acción.
 */
@Composable
fun UrgenciaDialog(
    urgencia: Urgencia,
    locationViewModel: LocationViewModel,
    onIniciarAvisoClick: () -> Unit,
    onFinalizarAvisoClick: () -> Unit,
    color: Color,
) {
    val initializated by locationViewModel.initializated.collectAsState()
    // Muestra un cuadro de diálogo.
    Dialog(
        onDismissRequest = { locationViewModel.openCloseEditUrg() },
        content = {
            // Contenedor de la superficie del diálogo.
            Surface(
                modifier = Modifier.width(300.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                // Columna que organiza el contenido verticalmente.
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Título del diálogo.
                    Text("Detalles de la urgencia", style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(8.dp))

                    // Muestra los detalles de la urgencia.
                    Text("Nombre: ${urgencia.name}")
                    Text("Edad: ${urgencia.age}")
                    Text("Prioridad: ${urgencia.priority}")
                    Text("Fecha: ${dateToString(urgencia.date!!)}")
                    Text("Descripción: ${urgencia.issues}")
                    Text("Ambulancia: ${urgencia.ambulance}")
                    Spacer(modifier = Modifier.height(16.dp))

                    // Fila que contiene los botones de acción.
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Botón para iniciar el aviso.
                        Button(
                            onClick = { onIniciarAvisoClick() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(color),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(2.dp, Color.Black),
                            enabled = !initializated
                        ) {
                            Text("Iniciar aviso",
                                color = Color.Black
                            )
                        }

                        // Botón para finalizar el aviso.
                        Button(
                            onClick = { onFinalizarAvisoClick() },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(color),
                            shape = RoundedCornerShape(6.dp),
                            border = BorderStroke(2.dp, Color.Black),
                            enabled = initializated
                        ) {
                            Text("Finalizar aviso",
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    )
}

@SuppressLint("SimpleDateFormat")
private fun dateToString(date: Timestamp): String{
    val sdf = SimpleDateFormat("HH:mm:ss dd/MM")
    val todate = date.toDate()
    return sdf.format(todate)
}