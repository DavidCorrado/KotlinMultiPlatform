package com.example.players.api

import com.example.players.model.Player
import kotlinx.serialization.Serializable

@Serializable
data class PlayersDoc (val players: List<Player>)
