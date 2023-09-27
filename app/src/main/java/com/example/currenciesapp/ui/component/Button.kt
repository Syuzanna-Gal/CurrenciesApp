package com.example.currenciesapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.theme.EgyptianBlue
import com.example.currenciesapp.ui.theme.White

@Composable
fun Button(title: String) {
    androidx.compose.material3.Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = White,
                fontStyle = FontStyle(R.font.inter),
                fontWeight = FontWeight(500),
            ),
            textAlign = TextAlign.Center,
        )
    }
}