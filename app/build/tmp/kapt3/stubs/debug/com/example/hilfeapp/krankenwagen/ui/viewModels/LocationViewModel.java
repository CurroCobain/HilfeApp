package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * ViewModel para manejar la lógica relacionada con la ubicación
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\u001eH\u0007J\u0006\u0010#\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u001eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000b\u00a8\u0006%"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addressText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAddressText", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setAddressText", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "emergencyLocation", "Lcom/google/android/gms/maps/model/LatLng;", "getEmergencyLocation", "setEmergencyLocation", "focusErAmb", "", "getFocusErAmb", "setFocusErAmb", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "fusedLocationClient$delegate", "Lkotlin/Lazy;", "userLocation", "getUserLocation", "setUserLocation", "alterFocus", "", "getAddressFromCoordinates", "geocoder", "Landroid/location/Geocoder;", "locat", "resetAddressText", "updateLocation", "app_debug"})
@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
public final class LocationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fusedLocationClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> addressText;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> userLocation;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> emergencyLocation;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> focusErAmb;
    
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
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
    public final kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> getEmergencyLocation() {
        return null;
    }
    
    public final void setEmergencyLocation(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getFocusErAmb() {
        return null;
    }
    
    public final void setFocusErAmb(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> p0) {
    }
    
    /**
     * Método para cambiar el foco entre urgencias y ambulancias
     */
    public final void alterFocus() {
    }
    
    /**
     * Método para obtener la ubicación del usuario
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void getUserLocation() {
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
     * Método para actualizar la ubicación
     */
    public final void updateLocation() {
    }
}