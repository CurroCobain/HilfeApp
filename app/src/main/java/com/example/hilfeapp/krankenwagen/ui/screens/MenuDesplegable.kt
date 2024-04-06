package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hilfeapp.R
import com.example.hilfeapp.krankenwagen.navigation.Routes
import kotlinx.coroutines.delay

/**
 * Composable que muestra el contenido del menú desplegable
 */
@Composable
fun NavigationMenu (navController: NavController){
    var row1Color by remember { mutableStateOf(Color.Transparent) }
    var row2Color by remember { mutableStateOf(Color.Transparent) }
    var row3Color by remember { mutableStateOf(Color.Transparent) }
    var row4Color by remember { mutableStateOf(Color.Transparent) }

    Column (Modifier.fillMaxWidth(0.8f))
    {
        //  ------------------------------------------- Banner superior -------------------------------
        Image(painter = painterResource(id = R.drawable.banner),
            contentDescription = "banner",
            Modifier
                .fillMaxWidth()
                .height(50.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp)
        ){
            Spacer(modifier = Modifier.padding(50.dp))

            // ---------------------------- Efecto de la linea configuración -------------------------------
            RowColorEffect(row1Color) { newColor ->
                row1Color = newColor
            }
            //  ------------------------------------------- Configuración -------------------------------
            Row(Modifier.fillMaxWidth()
                .background(color = row1Color)
                .clickable {
                    row1Color = Color.LightGray
                    navController.navigate(Routes.PantallaOptions.route)
                })
            {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Android Icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = "Configuración",
                    fontSize = 25.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))

            // ---------------------------- Efecto de la linea usuario -------------------------------
            RowColorEffect(row2Color) { newColor ->
                row2Color = newColor
            }
            //  ------------------------------------------- Usuario -------------------------------
            Row(Modifier.fillMaxWidth()
                .background(color = row2Color)
                .clickable {
                    row2Color = Color.LightGray
                    navController.navigate(Routes.PantallaUser.route)
                })
            {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Android Icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = "Usuario",
                    fontSize = 25.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))

            // ---------------------------- Efecto de la linea llamada -------------------------------
            RowColorEffect(row3Color) { newColor ->
                row3Color = newColor
            }
            //  ------------------------------------------- Llamada -------------------------------
            Row(Modifier.fillMaxWidth()
                .background(color = row3Color)
                .clickable {
                    row3Color = Color.LightGray
                    navController.navigate(Routes.PantallaCall.route)
                })
            {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Android Icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = "Llamada",
                    fontSize = 25.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))

            // ---------------------------- Efecto de la linea salir -------------------------------
            RowColorEffect(row4Color) { newColor ->
                row4Color = newColor
            }
            //  ------------------------------------------- Salir -------------------------------
            Row(Modifier.fillMaxWidth()
                .background(color = row4Color)
                .clickable { row4Color = Color.LightGray  })
            {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Android Icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = "Salir",
                    fontSize = 25.sp,
                    color = Color.Black
                )
            }
        }
    }
}

/**
 * Funcion que realiza el efecto de cambio de color de los botones al ser pulsados
 */
@Composable
fun RowColorEffect(color: Color, onColorChange: (Color) -> Unit) {
    LaunchedEffect(color) {
        if (color == Color.LightGray) {
            delay(200)
            onColorChange(Color.Transparent)
        }
    }
}