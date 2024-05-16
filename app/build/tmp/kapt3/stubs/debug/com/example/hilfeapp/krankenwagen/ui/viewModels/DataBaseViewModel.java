package com.example.hilfeapp.krankenwagen.ui.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0007J\u001c\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)J\u001c\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)J\u000e\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020.J\u0016\u0010/\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)H\u0007J\u0006\u00100\u001a\u00020%J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\fJ\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u000205J\u001c\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)J\u000e\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0011J\u0010\u0010<\u001a\u00020%2\u0006\u00104\u001a\u000205H\u0002J\u000e\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\fJ\u0018\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0011H\u0002J\u001e\u0010B\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u0006C"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "hospitalFiltrar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/hilfeapp/krankenwagen/data/Hospital;", "getHospitalFiltrar", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "listAmbulancias", "", "", "getListAmbulancias", "setListAmbulancias", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "listEr", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "getListEr", "listHospitals", "getListHospitals", "message", "getMessage", "miUrgencia", "getMiUrgencia", "myAmb", "getMyAmb", "provinciaFiltrar", "getProvinciaFiltrar", "shown", "", "getShown", "tempCounty", "", "getTempCounty", "()Ljava/util/List;", "finishUrg", "", "getAmb", "hospital", "onSuccess", "Lkotlin/Function0;", "getHosp", "provincia", "getPlateFromDocumentSnapshot", "documentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "getUrgencies", "intiUrg", "setAmb", "amb", "setAmbLoc", "location", "Lcom/google/android/gms/maps/model/LatLng;", "setCounty", "text", "setHosp", "hosp", "setUrg", "urg", "updateAmbulanceLocation", "updateMessage", "newValue", "updateUrgencia", "urgenciaId", "urgencia", "updateUrgenciasIfMatches", "app_debug"})
public final class DataBaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> message = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> shown = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tempCounty = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> provinciaFiltrar = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Hospital> hospitalFiltrar = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> listAmbulancias;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Hospital>> listHospitals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> myAmb = null;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Urgencia>> listEr = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Urgencia> miUrgencia = null;
    
    public DataBaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getShown() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTempCounty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getProvinciaFiltrar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Hospital> getHospitalFiltrar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> getListAmbulancias() {
        return null;
    }
    
    public final void setListAmbulancias(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Hospital>> getListHospitals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getMyAmb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Urgencia>> getListEr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Urgencia> getMiUrgencia() {
        return null;
    }
    
    /**
     * Obtiene la lista de hospitales para una provincia específica desde Firestore.
     * @param provincia La provincia para la cual se desean obtener los hospitales.
     * @param onSuccess La acción a ejecutar cuando se obtienen los hospitales exitosamente.
     */
    public final void getHosp(@org.jetbrains.annotations.NotNull()
    java.lang.String provincia, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Filtra las ambulancias por hospital de referencia desde Firestore.
     * @param hospital El hospital de referencia por el cual se desean filtrar las ambulancias.
     * @param onSuccess La acción a ejecutar cuando se obtienen las ambulancias exitosamente.
     */
    public final void getAmb(@org.jetbrains.annotations.NotNull()
    java.lang.String hospital, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Función que modifica el valor de provinciaFiltrar
     */
    public final void setCounty(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Función que modifica el valor de ciudadFiltrar
     */
    public final void setHosp(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.Hospital hosp) {
    }
    
    /**
     * Función para actualizar la ambulancia actual
     */
    public final void setAmb(@org.jetbrains.annotations.NotNull()
    java.lang.String amb) {
    }
    
    /**
     * Función para actualizar la urgencia actual
     */
    public final void setUrg(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.Urgencia urg) {
    }
    
    /**
     * Función para actualizar el valor de la ambulancia asociada a la urgencia
     */
    public final void intiUrg() {
    }
    
    /**
     * Función para finalizar una urgencia
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void finishUrg() {
    }
    
    /**
     * Función para actualizar la ubicación de la ambulancia actual
     */
    public final void setAmbLoc(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location) {
    }
    
    /**
     * Función para obtener la lista de urgencias de la base de datos
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void getUrgencies(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final void updateUrgenciasIfMatches(com.example.hilfeapp.krankenwagen.data.Urgencia miUrgencia, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final void updateUrgencia(java.lang.String urgenciaId, com.example.hilfeapp.krankenwagen.data.Urgencia urgencia) {
    }
    
    /**
     * Función para actualizar la ubicación de la ambulancia en la base de datos de Firestore
     */
    private final void updateAmbulanceLocation(com.google.android.gms.maps.model.LatLng location) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlateFromDocumentSnapshot(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        return null;
    }
    
    public final void updateMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String newValue) {
    }
}