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
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aJ\b\u0010\u001e\u001a\u00020!H\u0007J\u0006\u0010&\u001a\u00020!J\u0006\u0010\'\u001a\u00020!J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001aR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\"\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000b\u00a8\u0006*"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addressText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAddressText", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setAddressText", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "editUrg", "", "getEditUrg", "setEditUrg", "focusErAmb", "getFocusErAmb", "setFocusErAmb", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "fusedLocationClient$delegate", "Lkotlin/Lazy;", "urgencyLocation", "Lcom/google/android/gms/maps/model/LatLng;", "getUrgencyLocation", "setUrgencyLocation", "userLocation", "getUserLocation", "setUserLocation", "alterFocus", "", "getAddressFromCoordinates", "geocoder", "Landroid/location/Geocoder;", "locat", "openCloseEditUrg", "resetAddressText", "setUrLocation", "location", "app_debug"})
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
    private kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> urgencyLocation;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> focusErAmb;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> editUrg;
    
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
    public final kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> getUrgencyLocation() {
        return null;
    }
    
    public final void setUrgencyLocation(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.maps.model.LatLng> p0) {
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
    
    /**
     * Método para cambiar el foco entre urgencia y ambulancia
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
}