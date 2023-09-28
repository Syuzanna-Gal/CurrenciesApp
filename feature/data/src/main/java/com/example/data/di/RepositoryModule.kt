package com.example.data.di


import com.example.data.repository.CurrenciesRepositoryImpl
import com.example.data.repository.FavoriteRepositoryImpl
import com.example.domain.repository.CurrenciesRepository
import com.example.domain.repository.FavoriteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCurrencyRepository(impl: CurrenciesRepositoryImpl): CurrenciesRepository

    @Binds
    fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository

}