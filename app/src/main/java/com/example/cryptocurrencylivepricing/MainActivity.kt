package com.example.cryptocurrencylivepricing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.cryptocurrencylivepricing.model.Ticker
import com.example.cryptocurrencylivepricing.service.TickerListViewModel
import com.example.cryptocurrencylivepricing.view.CryptoLivePricingHomeContent
import com.example.cryptocurrencylivepricing.ui.theme.CryptocurrencyLivePricingTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyLivePricingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: TickerListViewModel = viewModel()) {
    val emptyList: List<Ticker> = listOf()
    val tickersList: List<Ticker> by viewModel.allMarketTickersList.observeAsState(emptyList)
    val query: String by viewModel.query.observeAsState("")
    Scaffold(
        content = {
            CryptoLivePricingHomeContent(
                tickersList = tickersList,
                onListChanged = { viewModel.onListChanged(it) },
                query = query,
                onQueryChanged = {viewModel.onQueryChanged(it)})
        }
    )
}