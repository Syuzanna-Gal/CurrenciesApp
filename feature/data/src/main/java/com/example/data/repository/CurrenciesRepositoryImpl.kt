package com.example.data.repository

import com.example.data.mapper.MapperCurrenciesJsonToUiEntity
import com.example.data.remote.api.MainApi
import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.repository.CurrenciesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrenciesRepositoryImpl @Inject constructor(
    private val mainApi: MainApi,
) : CurrenciesRepository {
    override fun fetchCurrencies(base: String): Flow<List<CurrencyUiEntity>> = flow {
        val currencies = mainApi.fetchCurrencies(base)
        emit(MapperCurrenciesJsonToUiEntity().map(currencies))
    }
}