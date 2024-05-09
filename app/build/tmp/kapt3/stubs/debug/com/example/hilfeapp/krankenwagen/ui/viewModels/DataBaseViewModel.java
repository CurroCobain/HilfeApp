package com.example.hilfeapp.krankenwagen.ui.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u001c\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\fJ\u001c\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u001c\u0010\'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DataBaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "hospitalFiltrar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/hilfeapp/krankenwagen/data/Hospital;", "getHospitalFiltrar", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "listAmbulancias", "", "Lcom/example/hilfeapp/krankenwagen/data/Ambulance;", "getListAmbulancias", "setListAmbulancias", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "listHospitals", "getListHospitals", "message", "", "myAmb", "getMyAmb", "provinciaFiltrar", "getProvinciaFiltrar", "tempCounty", "", "getTempCounty", "()Ljava/util/List;", "getAmb", "", "hospital", "onSuccess", "Lkotlin/Function0;", "getHosp", "provincia", "setAmb", "amb", "setCounty", "text", "setHosp", "hosp", "app_debug"})
public final class DataBaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> message;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tempCounty = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> provinciaFiltrar = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Hospital> hospitalFiltrar = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Ambulance>> listAmbulancias;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Hospital>> listHospitals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Ambulance> myAmb = null;
    
    public DataBaseViewModel() {
        super();
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
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Ambulance>> getListAmbulancias() {
        return null;
    }
    
    public final void setListAmbulancias(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Ambulance>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Hospital>> getListHospitals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.example.hilfeapp.krankenwagen.data.Ambulance> getMyAmb() {
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
    com.example.hilfeapp.krankenwagen.data.Hospital hosp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void setAmb(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.Ambulance amb) {
    }
}