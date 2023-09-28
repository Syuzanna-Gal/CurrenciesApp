package com.example.data.di


import com.example.data.repository.CurrenciesRepositoryImpl
import com.example.domain.repository.CurrenciesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCategoryRepository(impl: CurrenciesRepositoryImpl): CurrenciesRepository

}