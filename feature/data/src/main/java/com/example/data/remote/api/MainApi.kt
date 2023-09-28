package com.example.data.remote.api

import com.example.data.remote.entity.CategoriesEntity
import retrofit2.http.GET

interface MainApi {
    @GET("latest")
    suspend fun fetchCurrencies(): CategoriesEntity
}