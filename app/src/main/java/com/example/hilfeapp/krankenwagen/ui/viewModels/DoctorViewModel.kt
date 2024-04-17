package com.example.hilfeapp.krankenwagen.ui.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DoctorViewModel(): ViewModel(){
    var documentText = MutableStateFlow("")

}