package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * viewModel que gestiona las notificaciones de la app
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0003J\b\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/NotificationViewModel;", "Landroidx/lifecycle/ViewModel;", "baseViewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "locationViewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;", "(Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;)V", "previousUrgencySize", "", "sendNewUrgencyNotification", "", "startUrgencyUpdates", "app_debug"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
public final class NotificationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel baseViewModel = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel locationViewModel = null;
    private int previousUrgencySize = 0;
    
    public NotificationViewModel(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.DataBaseViewModel baseViewModel, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel locationViewModel) {
        super();
    }
    
    /**
     * Inicia la actualización periódica de urgencias cada 5 segundos.
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void startUrgencyUpdates() {
    }
    
    /**
     * Función para generar las notificaciones
     */
    @android.annotation.SuppressLint(value = {"ServiceCast", "MissingPermission"})
    private final void sendNewUrgencyNotification() {
    }
}