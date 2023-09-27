package com.example.currenciesapp.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currenciesapp.R
import com.example.currenciesapp.ui.theme.Jet

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Toolbar(
    title: String, isBackButtonVisible: Boolean = false
) {
    /* TopAppBar(
        title = {
            Text(title)
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
            )
        }
    )*/
    Row(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (isBackButtonVisible) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
            )
        }

        Text(
            text = title,
            style = TextStyle(
                fontSize = 22.sp,
                color = Jet,
                fontStyle = FontStyle(R.font.inter),
                fontWeight = FontWeight(700),
            ),
            modifier = if (isBackButtonVisible) {
                Modifier.padding(start = 20.dp)
            } else {
                Modifier
            },
        )
    }
}