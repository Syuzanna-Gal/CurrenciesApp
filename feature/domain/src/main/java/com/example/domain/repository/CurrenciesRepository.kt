package com.example.domain.repository

import com.example.domain.entity.CurrencyUiEntity
import kotlinx.coroutines.flow.Flow

interface CurrenciesRepository {

    fun fetchCurrencies(base: String = "EUR"): Flow<List<CurrencyUiEntity>>

}