package com.example.currenciesapp.ui.filter

import androidx.fragment.app.viewModels
import com.example.currenciesapp.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment() : BaseFragment<FilterViewModel>() {
    override val viewModel: FilterViewModel by viewModels()
}