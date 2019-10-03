package com.example.players.api

import com.example.players.httpClientEngine
import com.example.players.model.Player
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

class PlayersAPI {
    private val client by lazy {
        HttpClient(httpClientEngine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    @UnstableDefault
    suspend fun fetchPlayer(): PlayersDoc {
        val response = client.get<HttpResponse> {
            url("https://gist.githubusercontent.com/DavidCorrado/710931e13b21b4c067a8a75f0fdb5040/raw/bdb946375e7e4b40a0f21b8c8bb17276a75cc2c6/PlayersMin.json")
        }
        val jsonBody = response.readText()
        return Json.parse(PlayersDoc.serializer(), jsonBody)
    }
}