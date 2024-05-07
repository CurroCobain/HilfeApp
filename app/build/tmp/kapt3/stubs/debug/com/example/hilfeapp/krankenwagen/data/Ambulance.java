package com.example.hilfeapp.krankenwagen.data;

/**
 * Clase que representa las Ambulancias
 * @property id almacena el id de la ambulancia
 * @property plate almacena la matrícula de la ambulancia
 * @property isFree indica si la ambulancia está disponible
 * @property types indica de que tipo es la ambulancia
 * @property hospital indica el hospital de referencia
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0004H\u00c6\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/data/Ambulance;", "", "()V", "id", "", "plate", "isFree", "", "types", "Lcom/example/hilfeapp/krankenwagen/data/AmbulanceTypes;", "hospital", "(Ljava/lang/String;Ljava/lang/String;ZLcom/example/hilfeapp/krankenwagen/data/AmbulanceTypes;Ljava/lang/String;)V", "getHospital", "()Ljava/lang/String;", "setHospital", "(Ljava/lang/String;)V", "getId", "()Z", "setFree", "(Z)V", "getPlate", "getTypes", "()Lcom/example/hilfeapp/krankenwagen/data/AmbulanceTypes;", "setTypes", "(Lcom/example/hilfeapp/krankenwagen/data/AmbulanceTypes;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Ambulance {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String plate = null;
    private boolean isFree;
    @org.jetbrains.annotations.NotNull()
    private com.example.hilfeapp.krankenwagen.data.AmbulanceTypes types;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String hospital;
    
    public Ambulance(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String plate, boolean isFree, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.AmbulanceTypes types, @org.jetbrains.annotations.NotNull()
    java.lang.String hospital) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlate() {
        return null;
    }
    
    public final boolean isFree() {
        return false;
    }
    
    public final void setFree(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.AmbulanceTypes getTypes() {
        return null;
    }
    
    public final void setTypes(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.AmbulanceTypes p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHospital() {
        return null;
    }
    
    public final void setHospital(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Ambulance() {
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
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.AmbulanceTypes component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.Ambulance copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String plate, boolean isFree, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.AmbulanceTypes types, @org.jetbrains.annotations.NotNull()
    java.lang.String hospital) {
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