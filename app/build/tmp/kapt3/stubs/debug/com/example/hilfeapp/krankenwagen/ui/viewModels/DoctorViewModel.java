package com.example.hilfeapp.krankenwagen.ui.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\"J\u0006\u0010,\u001a\u00020\"R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007\u00a8\u0006-"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "city", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getCity", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "county", "getCounty", "documentText", "getDocumentText", "listAmb", "", "", "getListAmb", "listEr", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "getListEr", "myAmbulance", "getMyAmbulance", "tempCity", "", "getTempCity", "()Ljava/util/List;", "setTempCity", "(Ljava/util/List;)V", "tempCounty", "getTempCounty", "setTempCounty", "userRegistered", "", "getUserRegistered", "acceptEr", "", "urgencia", "loadAmbulances", "selectAmbulance", "amb", "setCity", "newCity", "setCounty", "newCounty", "setFree", "updateStatus", "app_debug"})
public final class DoctorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> documentText = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> userRegistered = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.Object>> listAmb = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Object> myAmbulance = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> tempCounty;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> tempCity;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> county = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> city = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Urgencia>> listEr = null;
    
    public DoctorViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getDocumentText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getUserRegistered() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.Object>> getListAmb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Object> getMyAmbulance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTempCounty() {
        return null;
    }
    
    public final void setTempCounty(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTempCity() {
        return null;
    }
    
    public final void setTempCity(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getCounty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Urgencia>> getListEr() {
        return null;
    }
    
    /**
     * Método para cargar las ambulancias
     */
    public final void loadAmbulances() {
    }
    
    /**
     * Método para seleccionar una ambulancia
     */
    public final void selectAmbulance(@org.jetbrains.annotations.NotNull()
    java.lang.Object amb) {
    }
    
    /**
     * Método para establecer el estado de la ambulancia como libre
     */
    public final void setFree() {
    }
    
    /**
     * Método para aceptar una urgencia
     */
    public final void acceptEr(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.Urgencia urgencia) {
    }
    
    /**
     * Método para actualizar el estado de la ambulancia en la base de datos
     */
    public final void updateStatus() {
    }
    
    public final void setCounty(@org.jetbrains.annotations.NotNull()
    java.lang.String newCounty) {
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String newCity) {
    }
}