import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.media.MediaRecorder
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.io.File
import java.util.Locale
import java.util.Timer
import kotlin.concurrent.schedule

@SuppressLint("StaticFieldLeak")
class CallViewModel(private val context: Context) : ViewModel() {

    private val number = "619033460" // Número de teléfono fijo
    private var callText = ""
    private var speechRecognizer: SpeechRecognizer? = null
    private lateinit var tts: TextToSpeech
    var incomingText = MutableStateFlow("")
    private var mediaRecorder: MediaRecorder? = null
    private lateinit var outputFile: File

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

    // Función para iniciar el reconocimiento de voz
    @SuppressLint("InlinedApi")
    fun startSpeechToText() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // Permisos no concedidos, solicitarlos si es necesario
            Log.e("CallViewModel", "Permissions not granted")
            return
        }

        // Verificar si el reconocimiento de voz ya está en curso
        if (speechRecognizer == null) {
            // Configurar el SpeechRecognizer si no está en curso
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
            speechRecognizer?.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {
                    // Acciones cuando el reconocimiento de voz está listo para comenzar
                    Log.d("CallViewModel", "Ready for speech")
                }

                override fun onBeginningOfSpeech() {
                    // Acciones al comenzar el discurso
                    Log.d("CallViewModel", "Beginning of speech")
                }

                override fun onRmsChanged(rmsdB: Float) {
                    // Cambios en el nivel de volumen del habla
                }

                override fun onBufferReceived(buffer: ByteArray?) {
                    // Buffer recibido
                }

                override fun onEndOfSpeech() {
                    // Acciones al finalizar el discurso
                    Log.d("CallViewModel", "End of speech")

                    // Iniciar un temporizador para reiniciar el reconocimiento después de un breve período
                    Timer("RestartSpeechRecognition", false).schedule(500) {
                        startSpeechToText() // Llamar a startSpeechToText() después de 1 segundo
                    }
                }

                override fun onError(error: Int) {
                    // Manejar errores
                    Log.e("CallViewModel", "Speech recognition error: $error")
                }

                override fun onResults(results: Bundle?) {
                    // Resultados del reconocimiento de voz
                    val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        // Se ha reconocido el habla, actualiza el texto reconocido en MutableStateFlow
                        val spokenText = matches[0]
                        incomingText.value = spokenText
                        Log.d("CallViewModel", "Spoken text: $spokenText")
                    }
                }

                override fun onPartialResults(partialResults: Bundle?) {
                    // Resultados parciales
                }

                override fun onEvent(eventType: Int, params: Bundle?) {
                    // Evento del reconocimiento de voz
                }
            })

            // Configurar el intent para iniciar el reconocimiento de voz
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
            }

            // Comenzar el reconocimiento de voz
            speechRecognizer?.startListening(intent)
        }
    }

    // Función para detener el reconocimiento de voz
    fun stopSpeechToText() {
        speechRecognizer?.stopListening()
        incomingText.value = ""
    }

    // Función para iniciar la conversión de texto a voz
    @SuppressLint("ServiceCast")
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

    // Limpiar recursos al destruir el ViewModel
    override fun onCleared() {
        super.onCleared()
        speechRecognizer?.destroy()
        tts.stop()
        tts.shutdown()
    }

}