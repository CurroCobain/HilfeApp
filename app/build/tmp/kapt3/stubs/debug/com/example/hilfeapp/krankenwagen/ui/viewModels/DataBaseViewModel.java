package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * ViewModel que gestiona la interacción con la base de datos y los datos relacionados con ella.
 *
 * @property message mensaje de respuesta
 * @property tempCounty listado de provincias para mostrar en la lista de filtrado
 * @property provinciaFiltrar provincia por la que se filtran los datos
 * @property hospitalFiltrar hospital por el que se filtran los datos
 * @property listAmbulancias listado de las matrículas de las ambulancias filtradas
 * @property myAmb matrícula de la ambulancia actual del usuario
 * @property listEr lista de las urgencias sin finalizar
 * @property miUrgencia urgencia que se está gestionando actualmente
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+H\u0007J\u001c\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+J\u001c\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+J\u0010\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0002J\u0016\u00103\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+H\u0007J\b\u00104\u001a\u00020)H\u0007J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\u0010J\u000e\u00107\u001a\u00020)2\u0006\u00108\u001a\u000209J\u001c\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+J\u000e\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\u000bJ\u0016\u0010>\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+H\u0007J\u000e\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0015J\u0014\u0010A\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+J\u0010\u0010B\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002J\u000e\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u0010J\u0018\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u0015H\u0003J\u001e\u0010H\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00152\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+H\u0003R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000f0\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000f0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\n\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\rR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'\u00a8\u0006I"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setFirestore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "hospitalFiltrar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/hilfeapp/krankenwagen/data/Hospital;", "getHospitalFiltrar", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "listAmbulancias", "", "", "getListAmbulancias", "setListAmbulancias", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "listEr", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "getListEr", "listHospitals", "getListHospitals", "message", "getMessage", "miUrgencia", "getMiUrgencia", "miUrgenciaState", "", "getMiUrgenciaState", "myAmb", "getMyAmb", "provinciaFiltrar", "getProvinciaFiltrar", "tempCounty", "", "getTempCounty", "()Ljava/util/List;", "finishUrg", "", "onSuccess", "Lkotlin/Function0;", "getAmb", "hospital", "getHosp", "provincia", "getPlateFromDocumentSnapshot", "documentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "getUrgencies", "intiUrg", "setAmb", "amb", "setAmbLoc", "location", "Lcom/google/android/gms/maps/model/LatLng;", "setCounty", "text", "setHosp", "hosp", "setNull", "setUrg", "urg", "unSetAmb", "updateAmbulanceLocation", "updateMessage", "newValue", "updateUrgencia", "urgenciaId", "urgencia", "updateUrgenciasIfMatches", "app_debug"})
public final class DataBaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.firestore.FirebaseFirestore firestore;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> message = null;
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
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> miUrgenciaState = null;
    
    public DataBaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getFirestore() {
        return null;
    }
    
    public final void setFirestore(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getMessage() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getMiUrgenciaState() {
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
     * Función para actualizar la ambulancia en uso
     */
    public final void setAmb(@org.jetbrains.annotations.NotNull()
    java.lang.String amb) {
    }
    
    /**
     * Función para actualizar la ambulancia en uso
     */
    public final void unSetAmb(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
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
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void intiUrg() {
    }
    
    /**
     * Función para finalizar una urgencia
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void finishUrg(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
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
    
    /**
     * Función para actualizar una urgencia si coincide con la actual que se está gestionando
     * @param miUrgencia urgencia actual
     * @param onSuccess acción a ejecutar si se actualiza la ambulancia con éxito
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void updateUrgenciasIfMatches(com.example.hilfeapp.krankenwagen.data.Urgencia miUrgencia, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Función que recibe una urgencia y la actualiza en la base de datos
     * @param urgenciaId id de la urgencia
     * @param urgencia urgencia actual
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void updateUrgencia(java.lang.String urgenciaId, com.example.hilfeapp.krankenwagen.data.Urgencia urgencia) {
    }
    
    /**
     * Función para actualizar la ubicación de la ambulancia en la base de datos de Firestore
     */
    private final void updateAmbulanceLocation(com.google.android.gms.maps.model.LatLng location) {
    }
    
    /**
     * Función para obtener la matrícula de una ambulancia concreta en la base de datos
     */
    private final java.lang.String getPlateFromDocumentSnapshot(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        return null;
    }
    
    /**
     * función para actualizar el valor del mensaje del sistema
     */
    public final void updateMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String newValue) {
    }
    
    /**
     * Función para modificar el valor de miUrgencia y eliminarla del listado de urgencias sin finalizar
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public final void setNull(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
}