package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * ViewModel para manejar la lógica relacionada con la ubicación.
 *
 * @property fusedLocationClient proporciona el cliente de ubiccación
 * @property addressText texto de la dirección
 * @property userLocation coordenadas de la ubicación del usuario
 * @property urgencyLocation coordenadas de la ubicación de la urgencia
 * @property focusErAmb indica dónde si enfoca el mapa
 * @property editUrg gestiona cuando se muestra el diálogo con la información de la urgencia
 * @property showToast gestiona cuando se muestran aviso especiales en la app
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u000201J&\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u0002032\u0006\u00107\u001a\u000203J\u0016\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\'J\u0016\u0010+\u001a\u00020.2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020.0=H\u0007J\u0006\u0010>\u001a\u00020.J\u0006\u0010?\u001a\u00020.J\u000e\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020\u000bJ\u0006\u0010B\u001a\u00020.J\u000e\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\'J\b\u0010E\u001a\u00020.H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\"\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\"\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\t\u00a8\u0006F"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addressText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAddressText", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setAddressText", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "cameraPosition", "Lcom/google/maps/android/compose/CameraPositionState;", "getCameraPosition", "setCameraPosition", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "editUrg", "", "getEditUrg", "setEditUrg", "focusErAmb", "getFocusErAmb", "setFocusErAmb", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "fusedLocationClient$delegate", "Lkotlin/Lazy;", "initializated", "getInitializated", "showToast", "getShowToast", "setShowToast", "urgencyLocation", "Lcom/google/android/gms/maps/model/LatLng;", "getUrgencyLocation", "setUrgencyLocation", "userLocation", "getUserLocation", "setUserLocation", "alterFocus", "", "checkInitializated", "miUrgencia", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "distanceBetween", "", "lat1", "lon1", "lat2", "lon2", "getAddressFromCoordinates", "geocoder", "Landroid/location/Geocoder;", "locat", "onSuccess", "Lkotlin/Function0;", "openCloseEditUrg", "resetAddressText", "setCameraPositionState", "position", "setToast", "setUrLocation", "location", "updateCameraPosition", "app_debug"})
@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
public final class LocationViewModel extends androidx.lifecycle.ViewModel {
    public android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> showToast;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fusedLocationClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> addressText;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> userLocation;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> urgencyLocation;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.maps.android.compose.CameraPositionState> cameraPosition;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> focusErAmb;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> editUrg;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> initializated = null;
    
    public LocationViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getShowToast() {
        return null;
    }
    
    public final void setShowToast(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> p0) {
    }
    
    private final com.google.android.gms.location.FusedLocationProviderClient getFusedLocationClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getAddressText() {
        return null;
    }
    
    public final void setAddressText(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> getUserLocation() {
        return null;
    }
    
    public final void setUserLocation(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> getUrgencyLocation() {
        return null;
    }
    
    public final void setUrgencyLocation(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.google.maps.android.compose.CameraPositionState> getCameraPosition() {
        return null;
    }
    
    public final void setCameraPosition(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.google.maps.android.compose.CameraPositionState> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getFocusErAmb() {
        return null;
    }
    
    public final void setFocusErAmb(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getEditUrg() {
        return null;
    }
    
    public final void setEditUrg(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getInitializated() {
        return null;
    }
    
    /**
     * Método para cambiar el foco entre urgencia y ambulancia
     */
    public final void alterFocus() {
    }
    
    /**
     * Comprueba si la urgencia tiene una ambulancia asignada y actualiza el valor de initializated en función del resultado
     */
    public final void checkInitializated(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.Urgencia miUrgencia) {
    }
    
    /**
     * Actualiza la posición del foco en el mapa
     */
    private final void updateCameraPosition() {
    }
    
    /**
     * Método para obtener la ubicación del usuario
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void getUserLocation(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Establece la ubicación de la urgencia en el mapa
     */
    public final void setUrLocation(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location) {
    }
    
    /**
     * Método para obtener la dirección a partir de las coordenadas
     */
    public final void getAddressFromCoordinates(@org.jetbrains.annotations.NotNull()
    android.location.Geocoder geocoder, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng locat) {
    }
    
    /**
     * Método para restablecer el texto de la dirección
     */
    public final void resetAddressText() {
    }
    
    /**
     * Función que muestra u oculta el diálogo con la información de la urgencia
     */
    public final void openCloseEditUrg() {
    }
    
    public final void setCameraPositionState(@org.jetbrains.annotations.NotNull()
    com.google.maps.android.compose.CameraPositionState position) {
    }
    
    /**
     * Cambia el valor de showToast
     */
    public final void setToast() {
    }
    
    /**
     * Calcula la distancia en kms entre dos puntos en el mapa se usa para filtrar las urgencias en el radio de acción del mapa
     * @return devuelve la distancia en kms entre dos puntos
     */
    public final double distanceBetween(double lat1, double lon1, double lat2, double lon2) {
        return 0.0;
    }
}