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

class MainVM() : BaseViewModel() {

    private val _players = KMutableLiveData<List<Player>>()

    val players: KLiveData<List<Player>> = _players
    init {
        _players.value = listOf(Player("David"),Player("Michael"),Player("Zach"),Player("Oscar"))
    }

    override fun onAppeared() {
        super.onAppeared()

        launch(Main) {
            try {
                val result = withContext(Dispatchers.Default) { PlayersAPI().fetchPlayer() }
                _players.value = result.players


            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

}