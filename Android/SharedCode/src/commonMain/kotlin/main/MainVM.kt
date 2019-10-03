package com.example.players.main

import com.example.players.BaseViewModel
import com.example.players.api.PlayersAPI
import com.example.players.live_data.KLiveData
import com.example.players.live_data.KMutableLiveData
import com.example.players.model.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.UnstableDefault

class MainVM(private val playersAPI: PlayersAPI) : BaseViewModel() {

    private val _players = KMutableLiveData<List<Player>>()

    val players: KLiveData<List<Player>> = _players


    override fun onAppeared() {
        super.onAppeared()

        launch(Main) {
            try {
                val result = withContext(Dispatchers.Default) { playersAPI.fetchPlayer() }
                _players.value = result.players


            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

}