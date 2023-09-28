package com.example.domain.usecase

import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.repository.CurrenciesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCurrenciesUseCase @Inject constructor(private val repository: CurrenciesRepository) {
    operator fun invoke(base: String = "EUR"): Flow<List<CurrencyUiEntity>> =
        repository.fetchCurrencies(base)
}