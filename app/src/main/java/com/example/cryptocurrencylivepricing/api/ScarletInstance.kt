package com.example.cryptocurrencylivepricing.api

import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.retry.ExponentialWithJitterBackoffStrategy
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

const val RETRY_BASE_DURATION = 5000L
const val RETRY_MAX_DURATION = 5000L
const val BINANCE_STREAM_URL = "wss://stream.binance.com:9443/ws"
val BACKOFF_STRATEGY = ExponentialWithJitterBackoffStrategy(RETRY_BASE_DURATION, RETRY_MAX_DURATION)

fun scarletInstance(): Scarlet {
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()
    return Scarlet.Builder()
        .webSocketFactory(okHttpClient.newWebSocketFactory(BINANCE_STREAM_URL))
        .addMessageAdapterFactory(GsonMessageAdapter.Factory())
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .backoffStrategy(BACKOFF_STRATEGY)
//        .lifecycle(AndroidLifecycle.ofLifecycleOwnerForeground(CryptoLivePricingApp, this))
        .build()
}