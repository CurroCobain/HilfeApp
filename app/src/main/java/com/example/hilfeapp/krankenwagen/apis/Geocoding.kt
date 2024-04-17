package com.example.hilfeapp.krankenwagen.apis

import com.example.hilfeapp.krankenwagen.data.NominatimResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {
    @GET("search")
    suspend fun getAddress(
        @Query("format") format: String = "json",
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): List<NominatimResponse>
}
