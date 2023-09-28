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

    @Query("SELECT SUM(quantity) FROM currency_item")
    fun sumOfQuantityAsFlow(): Flow<Int>

    @Query("SELECT * FROM currency_item WHERE id = :productId")
    fun findById(productId: Int): CurrencyItemDbEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(basketItem: CurrencyItemDbEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(basketItem: CurrencyItemDbEntity)

    @Delete
    suspend fun delete(basketItem: CurrencyItemDbEntity)

    @Query("DELETE FROM currency_item")
    suspend fun deleteAll()
}