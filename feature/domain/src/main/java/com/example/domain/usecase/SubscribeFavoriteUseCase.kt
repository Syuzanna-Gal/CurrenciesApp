package com.example.domain.usecase

import com.example.domain.repository.FavoriteRepository
import javax.inject.Inject

class SubscribeFavoriteUseCase @Inject constructor(private val repository: FavoriteRepository) {
    operator fun invoke() = repository.subscribeFavoriteItems()
}