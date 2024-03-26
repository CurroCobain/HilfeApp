package com.example.hilfeapp.krankenwagen.ui.viewModels

/*
  // Función para iniciar la grabación de audio
  fun startRecording() {
      if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
          != PackageManager.PERMISSION_GRANTED
      ) {
          // Permisos no concedidos, solicitarlos si es necesario
          Log.e("CallViewModel", "Permissions not granted")
          return
      }

      outputFile = File(context.externalCacheDir?.absolutePath, "recording.3gp")
      mediaRecorder = MediaRecorder().apply {
          setAudioSource(MediaRecorder.AudioSource.MIC)
          setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
          setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
          setOutputFile(outputFile.absolutePath)

          try {
              prepare()
              start()
              // Iniciar la conversión de audio a texto cuando comience la grabación
              convertAudioToText(outputFile)
          } catch (e: Exception) {
              Log.e("CallViewModel", "Error starting recording: ${e.message}")
          }
      }
  }

  // Función para detener la grabación de audio y convertirlo en texto
  fun stopRecording() {
      mediaRecorder?.apply {
          try {
              stop()
              release()
          } catch (e: Exception) {
              Log.e("CallViewModel", "Error stopping recording: ${e.message}")
          }
      }
  }


  // Función para convertir el audio grabado en texto usando la API de reconocimiento de voz de Android
  private fun convertAudioToText(audioFile: File) {
      val recognizerIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
          putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
          putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
          putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
      }

      val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
      speechRecognizer.setRecognitionListener(object : RecognitionListener {
          override fun onReadyForSpeech(params: Bundle?) {}
          override fun onBeginningOfSpeech() {}
          override fun onRmsChanged(rmsdB: Float) {}
          override fun onBufferReceived(buffer: ByteArray?) {}
          override fun onEndOfSpeech() {}
          override fun onError(error: Int) {}
          override fun onPartialResults(partialResults: Bundle?) {}
          override fun onEvent(eventType: Int, params: Bundle?) {}

          override fun onResults(results: Bundle?) {
              val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
              if (!matches.isNullOrEmpty()) {
                  val spokenText = matches[0]
                  incomingText.value = spokenText
                  Log.d("CallViewModel", "Spoken text: $spokenText")
              }
          }
      })
      speechRecognizer.startListening(recognizerIntent)
  }

   */