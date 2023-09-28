package com.example.currenciesapp.ui.currencies

import androidx.lifecycle.viewModelScope
import com.example.currenciesapp.core.base.BaseComposeViewModel
import com.example.currenciesapp.core.navigation.Command
import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.usecase.AddToFavoriteUseCase
import com.example.domain.usecase.DeleteFromFavoriteUseCase
import com.example.domain.usecase.FetchCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val fetchCurrenciesUseCase: FetchCurrenciesUseCase,
    private val addToFavoriteUseCase: AddToFavoriteUseCase,
    private val deleteFromFavoriteUseCase: DeleteFromFavoriteUseCase,
) : BaseComposeViewModel() {



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

    fun fetchCurrencies(base: String = DEFAULT_BASE) {
        fetchCurrenciesUseCase(base)
            .flowOn(Dispatchers.IO)
            .onEach {
                _currencies.value = it
            }
            .catch { }
            .launchIn(viewModelScope)
    }

    fun addOrRemoveFromFavorite(currencyUiEntity: CurrencyUiEntity) {
        if (currencyUiEntity.isFavorite) {
            deleteToFavorite(currencyUiEntity)
        } else {
            addToFavorite(currencyUiEntity)
        }
        fetchCurrencies(DEFAULT_BASE)
    }

    private fun addToFavorite(currencyUiEntity: CurrencyUiEntity) {
        viewModelScope.launch {
            addToFavoriteUseCase.invoke(currencyUiEntity)
        }
    }

    private fun deleteToFavorite(currencyUiEntity: CurrencyUiEntity) {
        viewModelScope.launch {
            deleteFromFavoriteUseCase.invoke(currencyUiEntity)
        }
    }

    companion object {
        const val DEFAULT_BASE = "EUR"
    }
}