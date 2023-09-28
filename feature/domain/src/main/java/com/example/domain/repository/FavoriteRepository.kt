package com.example.domain.repository

import com.example.domain.entity.CurrencyUiEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun subscribeFavoriteItems(): Flow<List<CurrencyUiEntity>>

    suspend fun getAllFavorites(): List<CurrencyUiEntity>

    suspend fun addToFavorite(currencyUiEntity: CurrencyUiEntity)

    suspend fun deleteFromFavorite(currencyUiEntity: CurrencyUiEntity)

}