package com.example.currenciesapp.ui.main

import androidx.fragment.app.viewModels
import com.example.currenciesapp.core.base.BaseFragment

class MainFragment() : BaseFragment<MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
}