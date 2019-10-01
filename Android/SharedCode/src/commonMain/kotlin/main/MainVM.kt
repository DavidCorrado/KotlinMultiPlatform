package com.example.players.main

import com.example.players.BaseViewModel
import com.example.players.platformName
import com.github.florent37.livedata.KLiveData
import com.github.florent37.livedata.KMediatorLiveData

class MainVM : BaseViewModel() {

    private val _name = KMediatorLiveData<String>()
    val name: KLiveData<String>
        get() = _name

    init {
        _name.value = "Kotlin Rocks on ${platformName()}"
    }
}