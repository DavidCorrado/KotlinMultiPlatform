package com.example.players.main

import com.example.players.BaseViewModel
import com.example.players.api.PlayersAPI
import com.example.players.live_data.KLiveData
import com.example.players.live_data.KMutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainVM(private val playersAPI: PlayersAPI) : BaseViewModel() {

    private val _name = KMutableLiveData<String>()

    val name: KLiveData<String> = _name

    override fun onAppeared() {
        super.onAppeared()

        launch(Main) {
            try {
                val result = withContext(Dispatchers.Default) { playersAPI.fetchPlayer() }
                _name.value = result.players[0].name + " - " + result.players[1].name + " - " + result.players[2].name + " - " + result.players[3].name
            } catch (e: Exception) {
                _name.value = e.message
            }
        }
    }

}