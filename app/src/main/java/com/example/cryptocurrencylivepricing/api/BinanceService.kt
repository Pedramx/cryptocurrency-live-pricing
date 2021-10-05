package com.example.cryptocurrencylivepricing.api

import com.example.cryptocurrencylivepricing.model.Subscribe
import com.example.cryptocurrencylivepricing.model.Ticker
import com.example.cryptocurrencylivepricing.model.TickerList
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface BinanceService {

    @Send
    fun sendSubscribe(subscribe: Subscribe)
    @Receive
    fun observeAllMarketTickers(): Flowable<List<Ticker>>
    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

}