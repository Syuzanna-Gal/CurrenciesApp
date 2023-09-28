package com.example.data.remote.api

import com.example.data.remote.entity.CurrencyEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MainApi {
    @GET("latest")
    suspend fun fetchCurrencies(
        @Query("base") base: String,
        @Query("symbols") symbols: String = "",
    ): CurrencyEntity
}