package com.example.hilfeapp.krankenwagen.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AmbScreen(navController: NavController, optionsViewModel: OptionsViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val color1 by optionsViewModel.color1.collectAsState()
    val fondo by optionsViewModel.fondo.collectAsState()


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
            ContenidoAmb(fondo)
        }
    }
}

@Composable
fun ContenidoAmb(fondo: Int){
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

            Text(
                text = "prueba de fondo",
                modifier = Modifier.padding(65.dp)
            )
        }
    }
}


