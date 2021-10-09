package com.example.cryptocurrencylivepricing.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencylivepricing.service.dataProvider
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.cryptocurrencylivepricing.model.Ticker

@Composable
fun CryptoLivePricingHomeContent(tickersList:List<Ticker>, query: String,
                                 onListChanged: (List<Ticker>) -> Unit,
                                 onQueryChanged: (String) -> Unit) {

    dataProvider(onListChange = onListChanged)
    Column {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.primary,
            elevation = 8.dp
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SearchBar(query = query, onQueryChanged = onQueryChanged,
                        tickersList = tickersList, onListChanged = onListChanged)
                }

            }
        }
        LazyColumn(
            Modifier.background(MaterialTheme.colors.surface),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        )
        {
            items(
                items = tickersList,
                itemContent = {
                    TickerListItem(ticker = it)
                }
            )
        }
    }
}