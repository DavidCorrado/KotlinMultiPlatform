package com.example.players.main

import com.example.players.BaseViewModel
import com.example.players.KLiveData
import com.example.players.KMutableLiveData
import com.example.players.platformName

class MainVM : BaseViewModel() {

    private val _name = KMutableLiveData<String>()
    val name: KLiveData<String> = _name

    init {
        _name.value = "Kotlin Rocks on ${platformName()}"
    }
}