package com.example.cryptocurrencylivepricing.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptocurrencylivepricing.model.Ticker

class TickerListViewModel : ViewModel() {

    private val _allMarketTickersList: MutableLiveData<List<Ticker>> = MutableLiveData(listOf())
    private val _query: MutableLiveData<String> = MutableLiveData("")
    val allMarketTickersList: LiveData<List<Ticker>> = _allMarketTickersList
    val query: LiveData<String> = _query

    fun onQueryChanged(newValue: String) {
        _query.postValue(newValue);
    }

    fun onListChanged(newTickersList: List<Ticker>){
        val searchQuery = _query.value
        if(searchQuery == "")
            _allMarketTickersList.postValue(newTickersList)
        else
            _allMarketTickersList.postValue(newTickersList.filter {
                it.symbol.contains(searchQuery!!.uppercase().toRegex())
            })
    }

}