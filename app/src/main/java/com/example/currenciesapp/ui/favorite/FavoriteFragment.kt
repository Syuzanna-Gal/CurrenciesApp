package com.example.currenciesapp.ui.favorite

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.example.currenciesapp.R
import com.example.currenciesapp.core.base.BaseComposeFragment
import com.example.currenciesapp.ui.component.CurrencyItem
import com.example.currenciesapp.ui.component.Toolbar
import com.example.currenciesapp.ui.theme.Cultured
import com.example.currenciesapp.ui.theme.CurrenciesAppTheme
import com.example.currenciesapp.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseComposeFragment<FavoriteViewModel>() {
    override val viewModel: FavoriteViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun InitView() {
        CurrenciesAppTheme {
            Scaffold {
                Column(
                    modifier = Modifier
                        .background(White)
                        .fillMaxHeight()
                ) {
                    Column(
                        modifier = Modifier
                            .background(Cultured)
                            .padding(16.dp)
                    ) {
                        Toolbar(title = stringResource(id = R.string.favorites_title))
                    }
                    Box(
                        modifier = Modifier
                            .background(White)
                            .padding(16.dp)
                    )
                    {
                        LazyColumn {
                            items(4) {
                                CurrencyItem(
                                    title = "AMD",
                                    value = it.toString(),
                                    isFavorite = true,
                                    onFavoriteStateChange = {},
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}