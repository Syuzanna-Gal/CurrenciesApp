package com.example.data.local.db.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "currency_item", [Index(value = ["created_at"])])
data class CurrencyItemDbEntity(
    @PrimaryKey
    val name: String,
    val price: Double,
    val isFavorite: Boolean = false,
    // note: mutable fields
    @ColumnInfo(name = "created_at")
    var createdAt: Long,
)