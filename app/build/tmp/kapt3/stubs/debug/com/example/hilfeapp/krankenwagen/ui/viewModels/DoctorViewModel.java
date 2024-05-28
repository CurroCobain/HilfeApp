package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020#J\u000e\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020\u000bJ\u0014\u0010(\u001a\u00020#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0*J\u0014\u0010+\u001a\u00020#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0*J\u000e\u0010,\u001a\u00020#2\u0006\u0010\'\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\rR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\r\u00a8\u0006."}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "documentText", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getDocumentText", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setFirestore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "<set-?>", "nombreDoc", "getNombreDoc", "nuevoMail", "getNuevoMail", "nuevoPass", "getNuevoPass", "sesionMessage", "getSesionMessage", "setSesionMessage", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "userRegistered", "", "getUserRegistered", "cambiaMail", "", "valor", "cambiaNombre", "cambiaPass", "value", "cerrarSesion", "onSuccess", "Lkotlin/Function0;", "sesionInit", "setMessage", "trueFalseSesionInit", "app_debug"})
public final class DoctorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.firestore.FirebaseFirestore firestore;
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
    
    public DoctorViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getFirestore() {
        return null;
    }
    
    public final void setFirestore(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore p0) {
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
    
    /**
     * Inicia sesión
     */
    public final void sesionInit(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    /**
     * Cierra la sesión del usuario actual
     */
    public final void cerrarSesion(@org.jetbrains.annotations.NotNull()
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
     * Cambia el valor de userRegistered
     */
    public final void trueFalseSesionInit() {
    }
    
    /**
     * Modifica el valor del mensaje del sistema
     */
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
}