package com.example.hilfeapp.krankenwagen.ui.viewModels

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilfeapp.MainActivity
import com.example.hilfeapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * viewModel que gestiona las notificaciones de la app
 */
@RequiresApi(Build.VERSION_CODES.O)
class NotificationViewModel(
    private val baseViewModel: DataBaseViewModel,
    private val locationViewModel: LocationViewModel
) : ViewModel() {

    // Variable para almacenar el tamaño previo de la lista de urgencias
    private var previousUrgencySize = 0

    /**
     * Inicia la actualización periódica de urgencias cada 5 segundos.
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun startUrgencyUpdates() {
        viewModelScope.launch {
            var currentUrgencySize = 0
            while (true) {
                baseViewModel.getUrgencies {
                    currentUrgencySize = baseViewModel.listEr.value.size
                    // Verificar si se ha añadido una nueva urgencia
                    if (currentUrgencySize > previousUrgencySize) {
                        previousUrgencySize = currentUrgencySize
                        sendNewUrgencyNotification()
                    }
                }

                // Actualizar el tamaño previo de la lista de urgencias
                previousUrgencySize = currentUrgencySize

                delay(3000) // Espera 5 segundos antes de la próxima actualización
            }
        }
    }

    /**
     * Función para generar las notificaciones
     */
    @SuppressLint("ServiceCast", "MissingPermission")
    private fun sendNewUrgencyNotification() {
        val notificationManager =
            locationViewModel.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Crea el canal de notificación si es necesario
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "URGENT_CHANNEL",
                "Urgencias",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificaciones de nuevas urgencias"
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Crea un intent para volver a la aplicación
        val intent = Intent(locationViewModel.context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            locationViewModel.context,
            0,
            intent,
            PendingIntent.FLAG_MUTABLE
        )

        // Crea la notificación
        val notification = NotificationCompat.Builder(locationViewModel.context, "URGENT_CHANNEL")
            .setSmallIcon(R.drawable.ambulancia)
            .setContentTitle("Nueva urgencia")
            .setContentText("Hay una nueva urgencia que necesita atención")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) // Asigna el PendingIntent a la notificación
            .setAutoCancel(true) // Hace que la notificación se cierre cuando el usuario la toque
            .build()

        // Muestra la notificación
        NotificationManagerCompat.from(locationViewModel.context).notify(1, notification)
    }
}