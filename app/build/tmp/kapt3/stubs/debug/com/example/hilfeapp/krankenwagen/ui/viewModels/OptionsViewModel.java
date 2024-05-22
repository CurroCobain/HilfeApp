package com.example.hilfeapp.krankenwagen.ui.viewModels;

/**
 * ViewModel para manejar la lógica de las opciones de la aplicación
 *
 * @property color1 almacena el color principal de la aplicación
 * @property fondo almacena el fondo de la aplicación
 * @property initialImage almacena la imagen de carga de la aplicación
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0015J+\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\t\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001c"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/ui/viewModels/OptionsViewModel;", "Landroidx/lifecycle/ViewModel;", "database", "Lcom/example/hilfeapp/krankenwagen/data/AppDatabase;", "(Lcom/example/hilfeapp/krankenwagen/data/AppDatabase;)V", "color1", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/ui/graphics/Color;", "getColor1", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "fondo", "", "getFondo", "initialImage", "getInitialImage", "textColor", "getTextColor", "exit", "", "getOptions", "Lcom/example/hilfeapp/krankenwagen/data/Options;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOptions", "image", "saveOptions-Iv8Zu3U", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTheme", "theme", "app_debug"})
public final class OptionsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.hilfeapp.krankenwagen.data.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.ui.graphics.Color> color1 = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> fondo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> initialImage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.ui.graphics.Color> textColor = null;
    
    public OptionsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.data.AppDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.ui.graphics.Color> getColor1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getFondo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> getInitialImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.ui.graphics.Color> getTextColor() {
        return null;
    }
    
    /**
     * Método para establecer el tema de la aplicación y guardar las opciones en la base de datos.
     * @param theme Índice del tema seleccionado.
     */
    public final void setTheme(int theme) {
    }
    
    /**
     * Método para obtener las opciones de configuración almacenadas en la base de datos.
     * @return Las opciones de configuración almacenadas, o null si no hay ninguna entrada en la base de datos.
     */
    private final java.lang.Object getOptions(kotlin.coroutines.Continuation<? super com.example.hilfeapp.krankenwagen.data.Options> $completion) {
        return null;
    }
    
    /**
     * Método para salir de la aplicación.
     */
    public final void exit() {
    }
}