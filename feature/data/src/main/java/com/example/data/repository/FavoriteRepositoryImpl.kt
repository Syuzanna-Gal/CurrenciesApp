package com.example.data.repository

import com.example.data.local.db.CurrencyItemDao
import com.example.data.mapper.MapperCurrencyDbEntityToUiEntity
import com.example.data.mapper.MapperCurrencyItemToDbEntity
import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepositoryImpl @Inject constructor(private val currencyItemDao: CurrencyItemDao) :
    FavoriteRepository {

    override fun subscribeFavoriteItems(): Flow<List<CurrencyUiEntity>> =
        currencyItemDao.findAllAsFlow().map {
            MapperCurrencyDbEntityToUiEntity().map(it)
        }

    override suspend fun getAllFavorites(): List<CurrencyUiEntity> = currencyItemDao.findAll().map { MapperCurrencyDbEntityToUiEntity().map(it) }

    override suspend fun addToFavorite(currencyUiEntity: CurrencyUiEntity) =
        currencyItemDao.insert(MapperCurrencyItemToDbEntity().map(currencyUiEntity))


    override suspend fun deleteFromFavorite(currencyUiEntity: CurrencyUiEntity) {
        MapperCurrencyItemToDbEntity().map(currencyUiEntity).let {
            currencyItemDao.delete(it)
        }
    }
}