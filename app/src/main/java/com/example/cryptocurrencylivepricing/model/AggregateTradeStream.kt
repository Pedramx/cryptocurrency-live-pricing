package com.example.cryptocurrencylivepricing.model

data class AggregateTradeStream (
    val e: String,  // Event type
    val E: Long,    // Event time
    val s: String,  // Symbol
    val a: Long,    // Aggregate trade ID
    val p: String,  // Price
    val q: String,  // Quantity
    val f: Long,    // First trade ID
    val l: Long,    // Last trade ID
    val T: Long,    // Trade time
    val m: Boolean  // Is the buyer the market maker?
)