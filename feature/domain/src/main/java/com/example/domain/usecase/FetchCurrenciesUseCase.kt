package com.example.domain.usecase

import com.example.domain.repository.CurrenciesRepository
import javax.inject.Inject

class FetchCurrenciesUseCase @Inject constructor(private val repository: CurrenciesRepository) {
   // operator fun invoke(id: Int): BasketItemUiEntity?
}