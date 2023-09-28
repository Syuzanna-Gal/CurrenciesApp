package com.example.data.mapper

import com.example.data.local.db.entity.CurrencyItemDbEntity
import com.example.domain.entity.CurrencyUiEntity

class MapperCurrencyDbEntityToUiEntity() :
    Mapper<CurrencyItemDbEntity, CurrencyUiEntity> {
    override fun map(from: CurrencyItemDbEntity): CurrencyUiEntity {
        return CurrencyUiEntity(
            name = from.name,
            value = from.value,
            isFavorite = true,
        )
    }
}