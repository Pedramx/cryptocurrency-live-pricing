package com.example.cryptocurrencylivepricing.service

import com.example.cryptocurrencylivepricing.api.BinanceService
import com.example.cryptocurrencylivepricing.api.scarletInstance
import com.example.cryptocurrencylivepricing.model.Subscribe
import com.example.cryptocurrencylivepricing.model.Ticker
import com.tinder.scarlet.WebSocket

fun dataProvider(onListChange: (List<Ticker>) -> Unit) {
    val ALL_MARKET_TradeS_SUBSCRIBE_MESSAGE = Subscribe(
        "SUBSCRIBE",
        listOf("!ticker@arr"),
        1
    )
    val scarlet = scarletInstance()
    val binanceService = scarlet.create<BinanceService>()

    binanceService.observeWebSocketEvent()
        .filter { it is WebSocket.Event.OnConnectionOpened<*> }
        .subscribe({
            binanceService.sendSubscribe(ALL_MARKET_TradeS_SUBSCRIBE_MESSAGE)
        })
    binanceService.observeAllMarketTickers()
        .subscribe({ tickersList ->
            onListChange(tickersList)
        })
}