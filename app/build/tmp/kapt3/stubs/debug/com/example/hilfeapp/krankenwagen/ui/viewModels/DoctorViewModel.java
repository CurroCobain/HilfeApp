package com.example.hilfeapp.krankenwagen.ui.viewModels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010\'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)J\u0014\u0010*\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001f0,J\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\t\u00a8\u0006/"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "documentText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getDocumentText", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "listEr", "", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "getListEr", "<set-?>", "nombreDoc", "getNombreDoc", "nuevoMail", "getNuevoMail", "nuevoPass", "getNuevoPass", "sesionMessage", "getSesionMessage", "setSesionMessage", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "userRegistered", "", "getUserRegistered", "acceptEr", "", "urgencia", "cambiaMail", "valor", "cambiaNombre", "cambiaPass", "value", "loadAmbulances", "selectAmbulance", "amb", "", "sesionInit", "onSuccess", "Lkotlin/Function0;", "setFree", "updateStatus", "app_debug"})
public final class DoctorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> documentText = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> sesionMessage;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> nombreDoc;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> nuevoPass;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> nuevoMail;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> userRegistered = null;
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
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getSesionMessage() {
        return null;
    }
    
    public final void setSesionMessage(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getNombreDoc() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getNuevoPass() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getNuevoMail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getUserRegistered() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.hilfeapp.krankenwagen.data.Urgencia>> getListEr() {
        return null;
    }
    
    /**
     * Inicia sesión
     */
    public final void sesionInit(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Asigna el nombre del usuario
     */
    public final void cambiaNombre() {
    }
    
    /**
     * Asigna el password del usuario
     */
    public final void cambiaPass(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    /**
     * Asigna el correo del usuario
     */
    public final void cambiaMail(@org.jetbrains.annotations.NotNull()
    java.lang.String valor) {
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
}