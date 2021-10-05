package com.example.cryptocurrencylivepricing.model

data class Subscribe (
    val method: String,
    val params: List<String>,
    val id: Long
)