package com.example.data.mapper

import com.example.domain.entity.CurrencyUiEntity
import kotlinx.serialization.json.JsonObject

class MapperCurrenciesJsonToUiEntity : Mapper<JsonObject, List<CurrencyUiEntity>> {
    override fun map(from: JsonObject): List<CurrencyUiEntity> {
        val currencies = mutableListOf<CurrencyUiEntity>()
        from.keys.forEach {
            currencies.add(CurrencyUiEntity(name = it))
        }
        from.values.forEach { jsonElement ->
            currencies.map {
                it.copy(value = jsonElement.toString())
            }
        }
        return currencies
    }
}
