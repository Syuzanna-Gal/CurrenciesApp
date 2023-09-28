package com.example.data.mapper

import com.example.data.remote.entity.CurrencyEntity
import com.example.domain.entity.CurrencyUiEntity

class MapperCurrenciesJsonToUiEntity(
    private val favorites: List<CurrencyUiEntity>
) : Mapper<CurrencyEntity, List<CurrencyUiEntity>> {

    override fun map(from: CurrencyEntity): List<CurrencyUiEntity> {
        var currencies = mutableListOf<CurrencyUiEntity>()
        val fvIds = favorites.associateBy { favorite -> favorite.name }
        from.rates.keys.forEach {
            currencies.add(CurrencyUiEntity(name = it, isFavorite = fvIds.containsKey(it)))
        }
        currencies = currencies.map {
            it.copy(value = from.rates[it.name] ?: "")
        }.toMutableList()

        return currencies
    }
}
