package com.example.hilfeapp.krankenwagen.data;

/**
 * Clase "Urgencia", que almacena la información de la emergencia para transmitirla al
 * servicio de emergencias
 * @property name: nombre y apellidos del paciente
 * @property doc: documento de identidad del usuario
 * @property age: edad del usuario
 * @property priority: indica el nivel de prioridad de la emergencia
 * @property location: localización del usuario
 * @property date: fecha de la urgencia
 * @property issues: descripción de la urgencia
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0017\u00a2\u0006\u0002\u0010\u0002BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0004H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003J\t\u0010+\u001a\u00020\fH\u00c6\u0003J\t\u0010,\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\t\u0010.\u001a\u00020\u0011H\u00c6\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\u0007H\u00d6\u0001J\t\u00103\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014\u00a8\u00064"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "", "()V", "name", "", "doc", "age", "", "priority", "location", "Lcom/google/android/gms/maps/model/LatLng;", "date", "Ljava/time/LocalDateTime;", "issues", "ambulance", "Lcom/example/hilfeapp/krankenwagen/data/Ambulance;", "complete", "", "(Ljava/lang/String;Ljava/lang/String;IILcom/google/android/gms/maps/model/LatLng;Ljava/time/LocalDateTime;Ljava/lang/String;Lcom/example/hilfeapp/krankenwagen/data/Ambulance;Z)V", "getAge", "()I", "getAmbulance", "()Lcom/example/hilfeapp/krankenwagen/data/Ambulance;", "setAmbulance", "(Lcom/example/hilfeapp/krankenwagen/data/Ambulance;)V", "getComplete", "()Z", "setComplete", "(Z)V", "getDate", "()Ljava/time/LocalDateTime;", "getDoc", "()Ljava/lang/String;", "getIssues", "getLocation", "()Lcom/google/android/gms/maps/model/LatLng;", "getName", "getPriority", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Urgencia {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String doc = null;
    private final int age = 0;
    private final int priority = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.maps.model.LatLng location = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDateTime date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issues = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.hilfeapp.krankenwagen.data.Ambulance ambulance;
    private boolean complete;
    
    public Urgencia(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String doc, int age, int priority, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String issues, @org.jetbrains.annotations.Nullable()
    com.example.hilfeapp.krankenwagen.data.Ambulance ambulance, boolean complete) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDoc() {
        return null;
    }
    
    public final int getAge() {
        return 0;
    }
    
    public final int getPriority() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.model.LatLng getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssues() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hilfeapp.krankenwagen.data.Ambulance getAmbulance() {
        return null;
    }
    
    public final void setAmbulance(@org.jetbrains.annotations.Nullable()
    com.example.hilfeapp.krankenwagen.data.Ambulance p0) {
    }
    
    public final boolean getComplete() {
        return false;
    }
    
    public final void setComplete(boolean p0) {
    }
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    public Urgencia() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.model.LatLng component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.hilfeapp.krankenwagen.data.Ambulance component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.Urgencia copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String doc, int age, int priority, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime date, @org.jetbrains.annotations.NotNull()
    java.lang.String issues, @org.jetbrains.annotations.Nullable()
    com.example.hilfeapp.krankenwagen.data.Ambulance ambulance, boolean complete) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}