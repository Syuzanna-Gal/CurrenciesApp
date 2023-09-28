package com.example.data.repository

import com.example.data.local.db.AppDatabase
import com.example.data.mapper.MapperCurrenciesJsonToUiEntity
import com.example.data.mapper.MapperCurrencyDbEntityToUiEntity
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
    private val appDatabase: AppDatabase,
) : CurrenciesRepository {
    override fun fetchCurrencies(base: String): Flow<List<CurrencyUiEntity>> = flow {
        val currencies = mainApi.fetchCurrencies(base)
        val favorites =
            appDatabase.basketItemDao().findAll().map { MapperCurrencyDbEntityToUiEntity().map(it) }
        emit(MapperCurrenciesJsonToUiEntity(favorites).map(currencies))
    }
}