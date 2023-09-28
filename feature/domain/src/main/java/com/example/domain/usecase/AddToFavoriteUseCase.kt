package com.example.domain.usecase

import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.repository.FavoriteRepository
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(private val repository: FavoriteRepository) {
    suspend operator fun invoke(currencyUiEntity: CurrencyUiEntity) =
        repository.addToFavorite(currencyUiEntity)
}