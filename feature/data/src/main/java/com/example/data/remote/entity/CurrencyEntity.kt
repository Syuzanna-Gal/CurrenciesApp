package com.example.data.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CurrencyEntity(
    @SerialName("rates")
    val rates: Map<String, String>
)