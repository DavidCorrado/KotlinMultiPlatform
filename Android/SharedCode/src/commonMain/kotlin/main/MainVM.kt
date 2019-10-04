package com.example.players.main

import com.example.players.ApplicationDispatcher
import com.example.players.BaseViewModel
import com.example.players.UIDispatcher
import com.example.players.api.PlayersAPI
import com.example.players.live_data.KLiveData
import com.example.players.live_data.KMutableLiveData
import com.example.players.model.Player
import com.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.UnstableDefault

class MainVM : BaseViewModel() {

    private val _players = KMutableLiveData<List<Player>>()

    val players: KLiveData<List<Player>> = _players

    @UnstableDefault
    override fun onAppeared() {
        super.onAppeared()
        launch(UIDispatcher) {
            val result = withContext(ApplicationDispatcher) { PlayersAPI().fetchPlayer() }
            _players.value = result.players
            Napier.d("Players API Success")
        }
    }

}