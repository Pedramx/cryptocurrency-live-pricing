package com.example.cryptocurrencylivepricing.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencylivepricing.service.DataProvider
import androidx.compose.foundation.lazy.items

@Composable
fun CryptoLivePricingHomeContent() {

    val trades = remember{ DataProvider.AggregateTradeStreamList }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = trades,
            itemContent = {
                TradesListItem(trade = it)
            }
        )
    }

}