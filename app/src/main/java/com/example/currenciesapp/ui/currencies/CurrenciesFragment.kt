package com.example.currenciesapp.ui.currencies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.component.CurrencyItem
import com.example.currenciesapp.ui.component.Toolbar
import com.example.currenciesapp.ui.theme.Cultured
import com.example.currenciesapp.ui.theme.White
import com.example.currenciesapp.ui.theme.WildBlueYonder
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
                    Column {
                        Column(
                            modifier = Modifier
                                .background(Cultured)
                                .padding(16.dp)
                        ) {
                            Toolbar(title = stringResource(id = R.string.currencies_title))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_filter),
                                contentDescription = null,
                                modifier = Modifier
                                    .border(
                                        width = 1.dp,
                                        color = WildBlueYonder,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(color = White, shape = RoundedCornerShape(8.dp))
                                    .padding(12.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .background(White)
                                .padding(16.dp)
                        )
                        {
                            LazyColumn {
                                items(4) {
                                    CurrencyItem(title = "AMD", value = it.toDouble())
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}