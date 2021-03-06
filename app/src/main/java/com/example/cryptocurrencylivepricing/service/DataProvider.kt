package com.example.cryptocurrencylivepricing.service

import com.example.cryptocurrencylivepricing.api.BinanceService
import com.example.cryptocurrencylivepricing.api.scarletInstance
import com.example.cryptocurrencylivepricing.model.Subscribe
import com.example.cryptocurrencylivepricing.model.Ticker
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

const val FIXED_DELAY = 2000L
val ALL_MARKET_TradeS_SUBSCRIBE_MESSAGE = Subscribe(
    "SUBSCRIBE",
    listOf("!ticker@arr"),
    1
)

fun dataProvider(onListChange: (List<Ticker>) -> Unit) {
    val scarlet = scarletInstance()
    val binanceService = scarlet.create<BinanceService>()
    binanceService.observeWebSocketEvent()
        .filter { it is WebSocket.Event.OnConnectionOpened<*> }
        .subscribe({
            binanceService.sendSubscribe(ALL_MARKET_TradeS_SUBSCRIBE_MESSAGE)
        })
    binanceService.observeAllMarketTickers()
        .subscribe({ tickersList ->
            runBlocking {
                launch(Dispatchers.Default) {
                    onListChange(tickersList.sortedByDescending { it.lastPrice.toDouble() })
                }
                delay(FIXED_DELAY)
            }
        })
}