package com.example.cryptocurrencylivepricing

import android.app.Application
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
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle

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
    Scaffold(
        content = {
            CryptoLivePricingHomeContent(tickersList = tickersList, onListChange = { viewModel.onListChange(it) })
        }
    )
}