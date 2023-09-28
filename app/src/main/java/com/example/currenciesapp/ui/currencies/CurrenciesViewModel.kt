package com.example.currenciesapp.ui.currencies

import com.example.currenciesapp.core.base.BaseComposeViewModel
import com.example.currenciesapp.core.navigation.Command
import com.example.domain.entity.CurrencyUiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor() : BaseComposeViewModel() {

    private val _currencies = MutableStateFlow<List<CurrencyUiEntity>>(emptyList())
    val currencies = _currencies.asStateFlow()

    init {
        fetchCurrencies()
    }

    fun navigateToFilters() {
        // val dir = MainFragmentDirections.actionToFilter()
        val dir = CurrenciesFragmentDirections.actionToFilter()
        sendCommand(Command.NavCommand(dir))
    }

    fun fetchCurrencies() {
        _currencies.value = listOf(
            CurrencyUiEntity(name = "AMD", value = 2.00, isFavorite = false),
            CurrencyUiEntity(name = "EUR", value = 3.00, isFavorite = false),
            CurrencyUiEntity(name = "AMD", value = 5.00, isFavorite = false),
            CurrencyUiEntity(name = "EUR", value = 2.00, isFavorite = true)
        )
    }

    fun updateCurrencies(){
        _currencies.value = listOf(
            CurrencyUiEntity(name = "AMD", value = 7.00, isFavorite = true),
            CurrencyUiEntity(name = "EUR", value = 3.00, isFavorite = false),
            CurrencyUiEntity(name = "AMD", value = 4.00, isFavorite = false),
            CurrencyUiEntity(name = "EUR", value = 2.00, isFavorite = false)
        )
    }
}