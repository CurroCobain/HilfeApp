package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * ViewModel que gestiona lo referente al usuario, iniciar/cerrar sesión, obtener el nombre, etc.
 * @property sesionMessage almacena el mensaje del sistema
 * @property nombreDoc almacena el nombre del doctor actual
 * @property nuevoPass almacena el password del doctor actual
 * @property nuevoMail almacena el mail del doctor actual
 * @property userRegistered booleano que indica si hay un usuario registrado o no
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020!J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0011J\u0014\u0010&\u001a\u00020!2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020!0(J\u0014\u0010)\u001a\u00020!2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020!0(J\u000e\u0010*\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014\u00a8\u0006,"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getFirestore", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "setFirestore", "(Lcom/google/firebase/firestore/FirebaseFirestore;)V", "<set-?>", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "nombreDoc", "getNombreDoc", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "nuevoMail", "getNuevoMail", "nuevoPass", "getNuevoPass", "sesionMessage", "getSesionMessage", "setSesionMessage", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "userRegistered", "", "getUserRegistered", "cambiaMail", "", "valor", "cambiaNombre", "cambiaPass", "value", "cerrarSesion", "onSuccess", "Lkotlin/Function0;", "sesionInit", "setMessage", "trueFalseSesionInit", "app_debug"})
public final class DoctorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.firestore.FirebaseFirestore firestore;
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