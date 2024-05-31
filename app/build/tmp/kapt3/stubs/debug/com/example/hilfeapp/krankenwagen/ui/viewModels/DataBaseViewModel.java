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
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/H\u0007J\u001c\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/J\u001c\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/J\u0010\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u000206H\u0002J\u0016\u00107\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/H\u0007J\b\u00108\u001a\u00020-H\u0007J\b\u00109\u001a\u00020-H\u0003J\u000e\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020>J\u001c\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u00122\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/J\u000e\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\rJ\u0016\u0010C\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/H\u0007J\u0006\u0010D\u001a\u00020-J\u000e\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u0017J\b\u0010G\u001a\u00020-H\u0003J\u0014\u0010H\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/J\u0010\u0010I\u001a\u00020-2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020\u0012J\u0018\u0010L\u001a\u00020-2\u0006\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\u0017H\u0003J\u001e\u0010O\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020\u00172\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0/H\u0003R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000f\u00a8\u0006P"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setFirestore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "hospitalFiltrar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/hilfeapp/krankenwagen/data/Hospital;", "getHospitalFiltrar", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "listAmbulancias", "", "", "getListAmbulancias", "setListAmbulancias", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "listEr", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "getListEr", "listHospitals", "getListHospitals", "message", "getMessage", "miUrgencia", "getMiUrgencia", "myAmb", "getMyAmb", "provinciaFiltrar", "getProvinciaFiltrar", "tempCounty", "", "getTempCounty", "()Ljava/util/List;", "updated", "", "getUpdated", "urgencySize", "getUrgencySize", "finishUrg", "", "onSuccess", "Lkotlin/Function0;", "getAmb", "hospital", "getHosp", "provincia", "getPlateFromDocumentSnapshot", "documentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "getUrgencies", "intiUrg", "sendNewUrgencyNotification", "setAmb", "amb", "setAmbLoc", "location", "Lcom/google/android/gms/maps/model/LatLng;", "setCounty", "text", "setHosp", "hosp", "setNull", "setSize", "setUrg", "urg", "startUrgencyUpdates", "unSetAmb", "updateAmbulanceLocation", "updateMessage", "newValue", "updateUrgencia", "urgenciaId", "urgencia", "updateUrgenciasIfMatches", "app_debug"})
@androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
public final class DataBaseViewModel extends androidx.lifecycle.AndroidViewModel {
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
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> updated = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> urgencySize = null;
    
    public DataBaseViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
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
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getUpdated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getUrgencySize() {
        return null;
    }
    
    /**
     * Inicia la actualización periódica de urgencias cada 5 segundos.
     */
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void startUrgencyUpdates() {
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
    
    @android.annotation.SuppressLint(value = {"ServiceCast", "MissingPermission"})
    private final void sendNewUrgencyNotification() {
    }
    
    public final void setSize() {
    }
}