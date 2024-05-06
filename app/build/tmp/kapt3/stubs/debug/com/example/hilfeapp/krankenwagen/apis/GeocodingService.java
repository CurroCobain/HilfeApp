package com.example.hilfeapp.krankenwagen.apis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/hilfeapp/krankenwagen/apis/GeocodingService;", "", "getAddress", "", "Lcom/example/hilfeapp/krankenwagen/data/NominatimResponse;", "format", "", "lat", "", "lon", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GeocodingService {
    
    @retrofit2.http.GET(value = "search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAddress(@retrofit2.http.Query(value = "format")
    @org.jetbrains.annotations.NotNull()
    java.lang.String format, @retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.hilfeapp.krankenwagen.data.NominatimResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}