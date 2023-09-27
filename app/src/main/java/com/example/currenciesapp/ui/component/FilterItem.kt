package com.example.currenciesapp.ui.component

import android.view.Gravity
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.theme.Jet

@Composable
fun FilterItem(title: String, isSelected: Boolean = false) {
    Row (
        verticalAlignment = Alignment.CenterVertically
            ){
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                color = Jet,
                fontStyle = FontStyle(R.font.inter),
                fontWeight = FontWeight(500),
            ),
            modifier = Modifier.weight(1f)
        )
        RadioButton(selected = isSelected, onClick = { })
    }
}