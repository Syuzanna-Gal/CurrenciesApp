package com.example.currenciesapp.ui.currencies

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
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
import com.example.currenciesapp.ui.theme.WildBlueYonder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrenciesFragment : BaseComposeFragment<CurrenciesViewModel>() {
    override val viewModel: CurrenciesViewModel by viewModels()

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
                        Toolbar(title = stringResource(id = R.string.currencies_title))
                        Row {
                            val options =
                                listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
                            var expanded by remember { mutableStateOf(false) }
                            var selectedOptionText by remember { mutableStateOf(options[0]) }
                            // We want to react on tap/press on TextField to show menu
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = { expanded = !expanded },
                                modifier = Modifier
                                    .background(color = White, shape = RoundedCornerShape(8.dp))
                                    .height(48.dp)
                                    .weight(1f)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .background(
                                            color = White,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .border(
                                            width = 1.dp,
                                            color = WildBlueYonder,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .padding(
                                            start = 16.dp,
                                            top = 14.dp,
                                            end = 16.dp,
                                            bottom = 14.dp
                                        )
                                        .menuAnchor(),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Text(
                                        text = selectedOptionText,
                                        modifier = Modifier.weight(1f),
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_arrow_down),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .rotate(if (expanded) 180f else 0f)
                                            .clickable {
                                                expanded = true
                                            }
                                    )
                                }
                                /* TextField(
                                 // The `menuAnchor` modifier must be passed to the text field for correctness.
                                 value = selectedOptionText,
                                 modifier = Modifier.menuAnchor().border(
                                     width = 1.dp,
                                     color = WildBlueYonder,
                                     shape = RoundedCornerShape(8.dp)
                                 )
                                     .background(color = White, shape = RoundedCornerShape(8.dp))
                                     .padding(12.dp),
                                 readOnly = true,
                                 onValueChange = {},
                                 trailingIcon = { Icon(
                                     painter = painterResource(id = R.drawable.ic_arrow_down),
                                     contentDescription = null,
                                     modifier = Modifier
                                         .rotate(if (expanded) 180f else 0f)
                                         .clickable {
                                             expanded = true
                                         }
                                 )}
                             )*/
                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                    modifier = Modifier
                                        .background(
                                            color = White,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .border(
                                            width = 1.dp,
                                            color = WildBlueYonder,
                                            shape = RoundedCornerShape(8.dp)
                                        ),
                                ) {
                                    options.forEach { selectionOption ->
                                        DropdownMenuItem(
                                            text = { Text(selectionOption) },
                                            onClick = {
                                                selectedOptionText = selectionOption
                                                expanded = false
                                            },
                                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                                        )
                                    }
                                }
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.ic_filter),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .border(
                                        width = 1.dp,
                                        color = WildBlueYonder,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .background(color = White, shape = RoundedCornerShape(8.dp))
                                    .padding(12.dp)
                                    .clickable {
                                        viewModel.navigateToFilters()
                                    },
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .background(White)
                            .padding(16.dp)
                    )
                    {
                        val currenciesState = viewModel.currencies.collectAsState()
                        LazyColumn {
                            items(currenciesState.value) { item ->
                                CurrencyItem(
                                    title = item.name,
                                    value = item.value,
                                    isFavorite = item.isFavorite,
                                    onFavoriteStateChange = {
                                        viewModel.updateCurrencies()
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}