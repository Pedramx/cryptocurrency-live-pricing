package com.example.cryptocurrencylivepricing.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptocurrencylivepricing.model.Ticker

class TickerListViewModel : ViewModel() {

    private val _allMarketTickersList: MutableLiveData<List<Ticker>> = MutableLiveData(listOf())
    val allMarketTickersList: LiveData<List<Ticker>> = _allMarketTickersList

    fun onListChange(newTickersList: List<Ticker>){
        _allMarketTickersList.postValue(newTickersList)
    }

}