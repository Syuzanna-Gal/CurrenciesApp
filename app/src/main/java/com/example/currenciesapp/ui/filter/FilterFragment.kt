package com.example.currenciesapp.ui.filter

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.viewModels
import com.example.currenciesapp.R
import com.example.currenciesapp.core.base.BaseComposeFragment
import com.example.currenciesapp.ui.component.Button
import com.example.currenciesapp.ui.component.FilterItem
import com.example.currenciesapp.ui.component.Toolbar
import com.example.currenciesapp.ui.filter.entity.FilterEnum
import com.example.currenciesapp.ui.theme.Cultured
import com.example.currenciesapp.ui.theme.CurrenciesAppTheme
import com.example.currenciesapp.ui.theme.SonicSilver
import com.example.currenciesapp.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : BaseComposeFragment<FilterViewModel>() {
    override val viewModel: FilterViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalStdlibApi::class)
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
                        Toolbar(
                            title = stringResource(id = R.string.filters_title),
                            isBackButtonVisible = true,
                            backButtonAction = { viewModel.navigateUp() }
                        )
                    }
                    Column(
                        modifier = Modifier
                            .background(White)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.filters_sort_by).uppercase(),
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = SonicSilver,
                                fontStyle = FontStyle(R.font.inter),
                                fontWeight = FontWeight(700),
                            ),
                            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
                        )
                        FilterEnum.values().forEach {
                            FilterItem(title = it.title)
                        }

                        Spacer(modifier = Modifier.weight(1f))
                        Button(title = stringResource(id = R.string.filters_apply))
                    }
                }
            }
        }
    }
}