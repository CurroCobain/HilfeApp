package com.example.hilfeapp.krankenwagen.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a(\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u001aF\u0010\u0018\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0019"}, d2 = {"MapContent", "", "context", "Landroid/content/Context;", "locationText", "", "userLocation", "Lcom/google/android/gms/maps/model/LatLng;", "locationViewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/LocationViewModel;", "geocoder", "Landroid/location/Geocoder;", "emergencyLocation", "focus", "", "fondo", "", "MapScreen", "navController", "Landroidx/navigation/NavController;", "optionsViewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/OptionsViewModel;", "doctorViewModel", "Lcom/example/hilfeapp/krankenwagen/ui/viewModels/DoctorViewModel;", "MyMap", "app_debug"})
public final class MapScreenKt {
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable()
    public static final void MapScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel locationViewModel, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.OptionsViewModel optionsViewModel, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.DoctorViewModel doctorViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MapContent(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String locationText, @org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng userLocation, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel locationViewModel, @org.jetbrains.annotations.NotNull()
    android.location.Geocoder geocoder, @org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng emergencyLocation, boolean focus, int fondo) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MyMap(@org.jetbrains.annotations.NotNull()
    android.location.Geocoder geocoder, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.hilfeapp.krankenwagen.ui.viewModels.LocationViewModel locationViewModel, @org.jetbrains.annotations.Nullable()
    java.lang.String locationText, @org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng userLocation, @org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng emergencyLocation, boolean focus) {
    }
}