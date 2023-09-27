package com.example.currenciesapp.ui.favorite

import androidx.fragment.app.viewModels
import com.example.currenciesapp.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FavoriteViewModel>() {
    override val viewModel: FavoriteViewModel by viewModels()
}