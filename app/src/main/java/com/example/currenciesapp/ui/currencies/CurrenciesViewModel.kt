package com.example.currenciesapp.ui.currencies

import com.example.currenciesapp.core.base.BaseViewModel
import com.example.currenciesapp.core.navigation.Command
import com.example.currenciesapp.ui.main.MainFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor() : BaseViewModel() {

    fun navigateToFilters() {
        val dir = MainFragmentDirections.actionToFilter()
        sendCommand(Command.NavCommand(dir))
    }
}