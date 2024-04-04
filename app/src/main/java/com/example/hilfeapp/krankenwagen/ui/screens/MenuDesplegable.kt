package com.example.hilfeapp.krankenwagen.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hilfeapp.R

/**
 * Composable que muestra el contenido del menú desplegable
 */
@Composable
fun NavigationMenu (){
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

            //  ------------------------------------------- Configuración -------------------------------
            Row(Modifier.fillMaxWidth())
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

            //  ------------------------------------------- Usuario -------------------------------
            Row(Modifier.fillMaxWidth())
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

            //  ------------------------------------------- Llamada -------------------------------
            Row(Modifier.fillMaxWidth())
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

            //  ------------------------------------------- Salir -------------------------------
            Row(Modifier.fillMaxWidth())
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