package com.example.currenciesapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.theme.AntiFlashWhite
import com.example.currenciesapp.ui.theme.Jet

@Composable
fun CurrencyItem(title: String, value: Double, isFavorite: Boolean = false) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .background(color = AntiFlashWhite, shape = RoundedCornerShape(12.dp))
            .padding(start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 16.sp,
                color = Jet,
                fontStyle = FontStyle(R.font.inter),
                fontWeight = FontWeight(500),
            )
        )
        Text(
            text = value.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                color = Jet,
                fontStyle = FontStyle(R.font.inter),
                fontWeight = FontWeight(600),
            )
        )
        Icon(
            painter = if (isFavorite) {
                painterResource(id = R.drawable.ic_favorite_selected)
            } else {
                painterResource(id = R.drawable.ic_favorite_deafult)
            },
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}