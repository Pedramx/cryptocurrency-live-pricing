package com.example.cryptocurrencylivepricing.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItemTextField (text: String){
    Column(
        modifier = Modifier
            .padding(PaddingValues(vertical = 8.dp, horizontal = 16.dp))
            .fillMaxHeight(),
        Arrangement.Center
    ) {
        Text(text = text, style = MaterialTheme.typography.h6)
    }
}