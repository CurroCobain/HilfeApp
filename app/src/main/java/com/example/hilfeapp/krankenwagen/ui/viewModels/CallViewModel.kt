package com.example.hilfeapp.krankenwagen.ui.viewModels

import androidx.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.net.Uri


import kotlinx.coroutines.flow.MutableStateFlow

class CallViewModel : ViewModel() {
    private var number = MutableStateFlow("619033460")
    fun makePhoneCall(context: Context) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${number.value}")
        }
        context.startActivity(intent)
    }
}