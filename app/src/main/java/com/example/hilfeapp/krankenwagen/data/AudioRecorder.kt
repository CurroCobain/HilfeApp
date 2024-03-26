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