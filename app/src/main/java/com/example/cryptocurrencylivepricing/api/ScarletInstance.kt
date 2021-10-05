package com.example.cryptocurrencylivepricing.api

import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient

fun scarletInstance(): Scarlet {
    val okHttpClient = OkHttpClient()
    return Scarlet.Builder()
        .webSocketFactory(okHttpClient.newWebSocketFactory("wss://stream.binance.com:9443/ws"))
        .addMessageAdapterFactory(GsonMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .build()
}