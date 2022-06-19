package com.juanguicj.ejer3.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainModelView:ViewModel() {
    private val currencyEmptyMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val currencyEmptyLiveData: LiveData<Boolean> = currencyEmptyMutableLiveData
    private val proceedMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val proceedLiveData: LiveData<Boolean> = proceedMutableLiveData
    private val resultMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val resultLiveData: LiveData<String> = resultMutableLiveData
    
    private var currency1Float = 0.0f
    private val usd = 3944.4f
    private val eur = 4133.47f
    
    fun validate(currency1: String) {
        when{
            currency1.isEmpty() ->
                currencyEmptyMutableLiveData.value = true
            else -> {
                proceedMutableLiveData.value = true
                currency1Float = currency1.toFloat() 
            }
        }
    }

    fun process(choiceCurrency1: String, choiceCurrency2: String) {
        when (choiceCurrency1) {
            "USD" -> currency1Float *= usd
            "EUR" -> currency1Float *= eur
        }

        when (choiceCurrency2) {
            "USD" -> currency1Float /= usd
            "EUR" -> currency1Float /= eur
        }
        resultMutableLiveData.value = currency1Float.toString()
    }
}