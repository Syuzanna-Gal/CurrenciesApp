package com.example.currenciesapp.ui.currencies

import androidx.fragment.app.viewModels
import com.example.currenciesapp.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrenciesFragment : BaseFragment<CurrenciesViewModel>() {
    override val viewModel: CurrenciesViewModel by viewModels()
}