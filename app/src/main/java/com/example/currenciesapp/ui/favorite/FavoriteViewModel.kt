package com.example.currenciesapp.ui.favorite

import androidx.lifecycle.viewModelScope
import com.example.currenciesapp.core.base.BaseComposeViewModel
import com.example.domain.entity.CurrencyUiEntity
import com.example.domain.usecase.DeleteFromFavoriteUseCase
import com.example.domain.usecase.SubscribeFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val subscribeFavoriteUseCase: SubscribeFavoriteUseCase,
    private val deleteFromFavoriteUseCase: DeleteFromFavoriteUseCase,
) : BaseComposeViewModel() {

    private val _favorites = MutableStateFlow<List<CurrencyUiEntity>>(emptyList())
    val favorites = _favorites.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        subscribeFavoriteUseCase()
            .flowOn(Dispatchers.IO)
            .onEach {
                _favorites.value = it
            }
            .catch { }
            .launchIn(viewModelScope)
    }

    fun deleteFromFavorite(currencyUiEntity: CurrencyUiEntity) {
        viewModelScope.launch {
            deleteFromFavoriteUseCase(currencyUiEntity)
        }
        getFavorites()
    }
}