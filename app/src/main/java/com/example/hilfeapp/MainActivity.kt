package com.example.hilfeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.hilfeapp.krankenwagen.data.DatabaseBuilder
import com.example.hilfeapp.krankenwagen.ui.screens.AppInitializationScreen
import com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel
import com.example.hilfeapp.ui.theme.HilfeAppTheme
import com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel
import com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = DatabaseBuilder.getDatabase(applicationContext)
        val locationViewModel = LocationViewModel(this)
        val optionsViewModel = OptionsViewModel(database)
        val doctorViewModel = DoctorViewModel()
        locationViewModel.getUserLocation()
        setContent {
            HilfeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppInitializationScreen(
                        optionsViewModel,
                        locationViewModel,
                        doctorViewModel)
                }
            }
        }
    }
}


