package com.example.hilfeapp.krankenwagen.data;

/**
 * Clase "Urgencia", que almacena la información de la emergencia para transmitirla al
 * servicio de emergencias
 * @property id: identificador de la urgencia
 * @property name: nombre y apellidos del paciente
 * @property doc: documento de identidad del usuario
 * @property age: edad del usuario
 * @property priority: indica el nivel de prioridad de la emergencia
 * @property location: localización del usuario
 * @property date: fecha de la urgencia
 * @property issues: descripción de la urgencia
 * @property ambulance: matrícula de la ambulancia que gestiona la urgencia
 * @property complete: indica si la urgencia ha sido resuelta
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u0000 52\u00020\u0001:\u00015B\u0007\b\u0017\u00a2\u0006\u0002\u0010\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0011H\u00c6\u0003J\t\u0010(\u001a\u00020\u0004H\u00c6\u0003J\t\u0010)\u001a\u00020\u0004H\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\t\u0010.\u001a\u00020\u0004H\u00c6\u0003J\t\u0010/\u001a\u00020\u0004H\u00c6\u0003Jo\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\bH\u00d6\u0001J\t\u00104\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014\u00a8\u00066"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "", "()V", "id", "", "name", "doc", "age", "", "priority", "location", "Lcom/google/android/gms/maps/model/LatLng;", "date", "Ljava/sql/Timestamp;", "issues", "ambulance", "complete", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/google/android/gms/maps/model/LatLng;Ljava/sql/Timestamp;Ljava/lang/String;Ljava/lang/String;Z)V", "getAge", "()I", "getAmbulance", "()Ljava/lang/String;", "setAmbulance", "(Ljava/lang/String;)V", "getComplete", "()Z", "setComplete", "(Z)V", "getDate", "()Ljava/sql/Timestamp;", "getDoc", "getId", "getIssues", "getLocation", "()Lcom/google/android/gms/maps/model/LatLng;", "getName", "getPriority", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
public final class Urgencia {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String doc = null;
    private final int age = 0;
    private final int priority = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.maps.model.LatLng location = null;
    @org.jetbrains.annotations.Nullable()
    private final java.sql.Timestamp date = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String issues = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ambulance;
    private boolean complete;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hilfeapp.krankenwagen.data.Urgencia.Companion Companion = null;
    
    public Urgencia(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String doc, int age, int priority, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp date, @org.jetbrains.annotations.NotNull()
    java.lang.String issues, @org.jetbrains.annotations.NotNull()
    java.lang.String ambulance, boolean complete) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIssues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmbulance() {
        return null;
    }
    
    public final void setAmbulance(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.model.LatLng component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.Urgencia copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String doc, int age, int priority, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.LatLng location, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp date, @org.jetbrains.annotations.NotNull()
    java.lang.String issues, @org.jetbrains.annotations.NotNull()
    java.lang.String ambulance, boolean complete) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001c\u0010\u0007\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tJ\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\r\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/data/Urgencia$Companion;", "", "()V", "fromDocumentSnapshot", "Lcom/example/hilfeapp/krankenwagen/data/Urgencia;", "documentSnapshot", "Lcom/google/firebase/firestore/DocumentSnapshot;", "mapToUrgencia", "map", "", "", "urgenciaToMap", "", "urgencia", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Función para deserializar un objeto urgencia desde la base de datos
         * Se ha personalizado para evitar errores
         */
        @android.annotation.SuppressLint(value = {"NewApi"})
        @org.jetbrains.annotations.NotNull()
        public final com.example.hilfeapp.krankenwagen.data.Urgencia fromDocumentSnapshot(@org.jetbrains.annotations.NotNull()
        com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<java.lang.String, java.lang.Object> urgenciaToMap(@org.jetbrains.annotations.NotNull()
        com.example.hilfeapp.krankenwagen.data.Urgencia urgencia) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.hilfeapp.krankenwagen.data.Urgencia mapToUrgencia(@org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, ? extends java.lang.Object> map) {
            return null;
        }
    }
}