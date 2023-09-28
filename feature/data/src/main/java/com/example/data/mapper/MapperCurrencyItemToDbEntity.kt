package com.example.data.mapper

import com.example.data.local.db.entity.CurrencyItemDbEntity
import com.example.domain.entity.CurrencyUiEntity

class MapperCurrencyItemToDbEntity : Mapper<CurrencyUiEntity, CurrencyItemDbEntity> {
    override fun map(from: CurrencyUiEntity): CurrencyItemDbEntity {
        return CurrencyItemDbEntity(
            name = from.name,
            createdAt = System.currentTimeMillis(),
            value = from.value,
        )
    }
}