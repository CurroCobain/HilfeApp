package com.example.hilfeapp.krankenwagen.data;

/**
 * Constructor de la base de datos.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\b\u0005\u00a8\u0006\t"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/data/DatabaseBuilder;", "", "()V", "INSTANCE", "Lcom/example/hilfeapp/krankenwagen/data/AppDatabase;", "INSTANCE$1", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
public final class DatabaseBuilder {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.hilfeapp.krankenwagen.data.AppDatabase INSTANCE$1;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.hilfeapp.krankenwagen.data.DatabaseBuilder INSTANCE = null;
    
    private DatabaseBuilder() {
        super();
    }
    
    /**
     * Devuelve una instancia única de la base de datos.
     * @param context Contexto de la aplicación.
     * @return Instancia de la base de datos.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.hilfeapp.krankenwagen.data.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}