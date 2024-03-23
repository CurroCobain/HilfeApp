package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.lifecycle.ViewModel
import java.util.*
import android.media.AudioManager

@SuppressLint("StaticFieldLeak")
class CallViewModel(private val context: Context) : ViewModel() {
    private val number = "619033460" // Número de teléfono fijo
    private var callText = ""
    private lateinit var tts: TextToSpeech

    // Inicialización del TextToSpeech al crear una instancia del ViewModel
    init {
        initTextToSpeech()
    }

    // Función para inicializar el TextToSpeech
    private fun initTextToSpeech() {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.getDefault())
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("CallViewModel", "Error: Language not supported")
                }
            } else {
                Log.e("CallViewModel", "Error initializing TextToSpeech")
            }
        }
    }

    // Función para realizar una llamada telefónica
    fun makePhoneCall() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = android.net.Uri.parse("tel:$number")
        }
        context.startActivity(intent)
    }

    // Función para agregar el texto que se convertirá a voz
    fun addCallText(text: String) {
        callText = text
    }

    // Función para eliminar el texto que se convertirá a voz
    fun removeCallText() {
        callText = ""
    }

    // Función para iniciar la conversión de texto a voz
    fun startTextToSpeech(callText: String) {
        // Configuración del listener para controlar el progreso de la conversión
        tts.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                // Log.d("CallViewModel", "TTS started")
            }

            override fun onDone(utteranceId: String?) {
                // Log.d("CallViewModel", "TTS done")
                // Acciones después de que la conversión a voz haya finalizado
            }

            @Suppress("DEPRECATION")
            override fun onError(utteranceId: String?) {
                // Log.e("CallViewModel", "TTS error")
            }
        })

        // Configurar el enrutamiento de audio al altavoz
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.mode = AudioManager.MODE_NORMAL
        audioManager.isSpeakerphoneOn = true

        // Iniciar la conversión de texto a voz
        tts.speak(callText, TextToSpeech.QUEUE_FLUSH, null, "call_text")
    }

    // Función para limpiar los recursos utilizados por TextToSpeech
    override fun onCleared() {
        super.onCleared()
        tts.stop()
        tts.shutdown()
    }
}