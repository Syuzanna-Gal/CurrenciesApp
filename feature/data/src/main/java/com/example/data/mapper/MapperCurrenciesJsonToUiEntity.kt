package com.example.data.mapper

import com.example.data.remote.entity.CurrencyEntity
import com.example.domain.entity.CurrencyUiEntity

class MapperCurrenciesJsonToUiEntity : Mapper<CurrencyEntity, List<CurrencyUiEntity>> {
    override fun map(from: CurrencyEntity): List<CurrencyUiEntity> {
        var currencies = mutableListOf<CurrencyUiEntity>()
        from.rates.keys.forEach {
            currencies.add(CurrencyUiEntity(name = it))
        }
        currencies = currencies.map {
            it.copy(value = from.rates[it.name] ?: "")
        }.toMutableList()

        return currencies
    }
}
