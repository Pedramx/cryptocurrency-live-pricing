package com.example.cryptocurrencylivepricing.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencylivepricing.service.dataProvider
import androidx.compose.foundation.lazy.items
import com.example.cryptocurrencylivepricing.model.Ticker

@Composable
fun CryptoLivePricingHomeContent(tickersList:List<Ticker>, onListChange: (List<Ticker>) -> Unit) {

    dataProvider(onListChange = onListChange)

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tickersList,
            itemContent = {
                TickerListItem(ticker = it)
            }
        )
    }

}