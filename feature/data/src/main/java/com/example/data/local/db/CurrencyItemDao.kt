package com.example.data.local.db

import androidx.room.*
import com.example.data.local.db.entity.CurrencyItemDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyItemDao {

    @Query("SELECT * FROM currency_item")
    suspend fun findAll(): List<CurrencyItemDbEntity>

    @Query("SELECT * FROM currency_item")
    fun findAllAsFlow(): Flow<List<CurrencyItemDbEntity>>

    @Query("SELECT * FROM currency_item WHERE name = :name")
    fun findByName(name: String): CurrencyItemDbEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currencyItem: CurrencyItemDbEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(currencyItem: CurrencyItemDbEntity)

    @Delete
    suspend fun delete(currencyItem: CurrencyItemDbEntity)

    @Query("DELETE FROM currency_item")
    suspend fun deleteAll()
}