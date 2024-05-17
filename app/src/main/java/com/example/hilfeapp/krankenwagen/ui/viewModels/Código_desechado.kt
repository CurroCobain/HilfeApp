package com.example.hilfeapp.krankenwagen.ui.viewModels

// Cotenido desechado ---------- borrar ------------------

/*


package com.example.hilfeapp.krankenwagen.data

import android.media.MediaRecorder

class AudioRecorder {

   private var mediaRecorder: MediaRecorder? = null
   private var isRecording = false

   fun startRecording(outputFile: String) {
       if (isRecording) return

       mediaRecorder = MediaRecorder().apply {
           setAudioSource(MediaRecorder.AudioSource.MIC)
           setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
           setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
           setOutputFile(outputFile)

           try {
               prepare()
               start()
               isRecording = true
           } catch (e: Exception) {
               e.printStackTrace()
           }
       }
   }

   fun stopRecording() {
       mediaRecorder?.apply {
           if (isRecording) {
               stop()
               release()
               isRecording = false
           }
       }
   }
}


package com.example.hilfeapp.krankenwagen.MyconnectionService

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.media.AudioManager
import android.net.Uri
import android.os.Build
import android.telecom.Connection
import android.telecom.ConnectionRequest
import android.telecom.ConnectionService
import android.telecom.PhoneAccountHandle
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

abstract class ConnectionService : Service()


class MyConnectionService : ConnectionService() {

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreateOutgoingConnection(phoneAccountHandle: PhoneAccountHandle, request: ConnectionRequest): Connection {
        val connection = MyConnection(applicationContext)
        connection.setConnectionCapabilities(Connection.CAPABILITY_SUPPORT_HOLD)
        connection.setConnectionProperties(Connection.PROPERTY_SELF_MANAGED)
        return connection
    }

    override fun onCreateOutgoingConnectionFailed(phoneAccountHandle: PhoneAccountHandle, request: ConnectionRequest) {
        // Handle failure to create outgoing connection (e.g., show error to user)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateIncomingConnection(phoneAccountHandle: PhoneAccountHandle, request: ConnectionRequest): Connection {
        val connection = MyConnection(applicationContext)
        connection.setConnectionCapabilities(Connection.CAPABILITY_SUPPORT_HOLD)
        connection.setConnectionProperties(Connection.PROPERTY_SELF_MANAGED)
        connection.setVideoState(request.videoState)
        return connection
    }

    override fun onCreateIncomingConnectionFailed(phoneAccountHandle: PhoneAccountHandle, request: ConnectionRequest) {
        // Handle failure to create incoming connection (e.g., reject silently)
    }
}



import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.telecom.TelecomManager
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale

@SuppressLint("StaticFieldLeak")
class CallViewModel(private val context: Context) : ViewModel() {


    private val telecomManager: TelecomManager by lazy {
        context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
    }
    var number = MutableStateFlow("")
        private set
    var callText = MutableStateFlow("")
        private set
    private var speechRecognizer: SpeechRecognizer? = null
    private lateinit var tts: TextToSpeech
    val incomingText = MutableStateFlow("")
    // private var mediaRecorder: MediaRecorder? = null
    // private lateinit var outputFile: File

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
    @SuppressLint("MissingPermission")
     fun makePhoneCall(numeroTelefono: String) {
        val uri = Uri.fromParts("tel", numeroTelefono, null)
        val extras = Bundle().apply { putBoolean(TelecomManager.EXTRA_START_CALL_WITH_SPEAKERPHONE, true) }
        telecomManager.placeCall(uri, extras)
    }


    // Función para agregar el texto que se convertirá a voz
    fun addCallText(text: String) {
        callText.value = text
    }

    // Función para eliminar el texto que se convertirá a voz
    fun removeCallText() {
        callText.value = ""
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

        // Configurar el SpeechRecognizer
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
                    editIncomingText(spokenText)
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

    // Función para detener el reconocimiento de voz
    fun stopSpeechToText() {
        speechRecognizer?.stopListening()
        incomingText.value = ""
    }

    // Función para iniciar la conversión de texto a voz y enviarla al altavoz
    @SuppressLint("ServiceCast")
    fun startTextToSpeech(callText: String) {
        // Configurar el enrutamiento de audio al micrófono
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.mode = AudioManager.MODE_IN_CALL
        audioManager.isSpeakerphoneOn = false

        // Configurar la ruta de audio al micrófono
        val params = Bundle()
        params.putInt(TextToSpeech.Engine.KEY_PARAM_STREAM, AudioManager.MODE_IN_CALL)

        // Configurar el listener para controlar el progreso de la conversión
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

        // Iniciar la conversión de texto a voz y enviarla al micrófono
        tts.speak(callText, TextToSpeech.QUEUE_FLUSH, params, "call_text")
    }


    // Limpiar recursos al destruir el ViewModel
    override fun onCleared() {
        super.onCleared()
        speechRecognizer?.destroy()
        tts.stop()
        tts.shutdown()
    }

    fun editIncomingText(text: String){
        incomingText.value = text
    }

    fun deleteIncomingText(){
        incomingText.value = ""
    }

    suspend fun wait(){
        delay(1000)
    }

    fun setNumber(value: String){
        number.value = value
    }
}


import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Composable principal de la página de llamada
 */
@Composable
fun CallScreen(
    callViewModel: CallViewModel,
    navController: NavController
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationMenu(navController)
            }
        })
    {
        Llamada(callViewModel, drawerState)
    }
}

/**
 * Composable que muestra el contenido de la página de llamada
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Llamada(
    callViewModel: CallViewModel,
    drawerState: DrawerState)
{
    // ---------------------- Variables de la screen ---------------------------------------------
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val resultText by callViewModel.incomingText.collectAsState()
    val message by callViewModel.callText.collectAsState()
    val phone by callViewModel.number.collectAsState()
    var button1Color by remember { mutableStateOf(Color.Red) }
    var button2Color by remember { mutableStateOf(Color.Red) }
    var button3Color by remember { mutableStateOf(Color.Red) }
    var button4Color by remember { mutableStateOf(Color.Red) }

    // ------------------------------ Scaffold del menú desplegable --------------------------------
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Mostrar menú") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            )
        }
    ) {// -------------------- Columna principal ------------------------------------
        // Screen content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // ------------------------------ Textfield para TTS ---------------------------------------
            TextField(
                value = message,
                onValueChange = { newValue ->
                    callViewModel.addCallText(newValue)
                },
                placeholder = { Text(text = "Introduce el mensaje que quieres enviar") },
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.2f),
            )
            // ---------------------- Efecto del botón de llamada ---------------------------------
            ButtonColorEffect(button1Color) { newColor ->
                button1Color = newColor
            }
            // ------------------------------ Textfield para el número de teléfono ---------------------------------------
            TextField(
                value = phone,
                onValueChange = { newValue ->
                    callViewModel.setNumber(newValue)
                },
                placeholder = { Text(text = "Introduce el número de teléfono") },
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.2f),
            )
            // ----------------------- Botón de llamada ------------------------------------------
            Button(
                onClick = {
                    button1Color = Color.Green
                    callViewModel.makePhoneCall(phone)
                },
                colors = ButtonDefaults.buttonColors(button1Color)
            ) {
                Text(text = "Llamar")
            }
            // ---------------------- Efecto del botón de TTS ---------------------------------
            ButtonColorEffect(button2Color) { newColor ->
                button2Color = newColor
            }
            // -------------------------------- Botón de TTS ---------------------------------
            Button(
                onClick = {
                    button2Color = Color.Green
                    callViewModel.startTextToSpeech(message)
                },
                colors = ButtonDefaults.buttonColors(button2Color)
            ) {
                Text(text = "Lanzar texto")
            }
            // ---------------------- Efecto del botón de STT ---------------------------------
            ButtonColorEffect(button3Color) { newColor ->
                button3Color = newColor
            }
            // -------------------------------- Botón de STT ---------------------------------
            Button(
                onClick = {
                    button3Color = Color.Green
                    callViewModel.startSpeechToText()
                },
                colors = ButtonDefaults.buttonColors(button3Color),
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Grabar mensaje")
            }
            // ---------------------- Efecto del botón de borrar ---------------------------------
            ButtonColorEffect(button4Color) { newColor ->
                button4Color = newColor
            }
            // ------------------------- Botón de borrar campos ---------------------------------
            Button(
                onClick = {
                    button4Color = Color.Green
                    callViewModel.removeCallText()
                    callViewModel.deleteIncomingText()
                },
                colors = ButtonDefaults.buttonColors(button4Color)
            ) {
                Text(text = "Borrar resultados")
            }
            Text(text = resultText,
                Modifier
                    .border(width = 2.dp, color = Color.Black)
                    .sizeIn(minWidth = 250.dp, minHeight = 50.dp, maxWidth = 300.dp)
                    .wrapContentSize()
            )
        }
    }
}

/**
 * Funcion que realiza el efecto de cambio de color de los botones al ser pulsados
 */
@Composable
fun ButtonColorEffect(color: Color, onColorChange: (Color) -> Unit) {
    LaunchedEffect(color) {
        if (color == Color.Green) {
            delay(200)
            onColorChange(Color.Red)
        }
    }
}

*/