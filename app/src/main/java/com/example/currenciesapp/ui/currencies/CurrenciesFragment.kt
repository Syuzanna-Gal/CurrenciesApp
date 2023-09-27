package com.example.currenciesapp.ui.currencies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.component.Toolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrenciesFragment : Fragment() {
    // override val viewModel: CurrenciesViewModel by viewModels()
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Scaffold() {
                    Toolbar(title = stringResource(id = R.string.currencies_title))
                }
            }
        }
    }
}