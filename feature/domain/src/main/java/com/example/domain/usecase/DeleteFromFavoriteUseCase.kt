package com.example.domain.usecase

import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.repository.FavoriteRepository
import javax.inject.Inject

class DeleteFromFavoriteUseCase @Inject constructor(private val repository: FavoriteRepository) {
    suspend operator fun invoke(currencyUiEntity: CurrencyUiEntity) =
        repository.deleteFromFavorite(currencyUiEntity)
}