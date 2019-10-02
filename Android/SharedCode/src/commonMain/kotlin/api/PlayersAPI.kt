package com.example.players.api

import com.example.players.model.Player
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import kotlinx.serialization.json.Json

class PlayersAPI(private val engine: HttpClientEngine) {
    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }

    suspend fun fetchPlayer(): Player {
        val response =  client.get<HttpResponse> {
            url("https://gist.githubusercontent.com/DavidCorrado/2012b84c6c2e5f34fe58323255dc6d45/raw/63ea2a6127004b2a37b052888b063294caded827/Player.json")
        }
        val jsonBody = response.readText()
        return Json.parse(Player.serializer(), jsonBody)
    }
}