package com.example.players

import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.CoroutineDispatcher

internal expect val httpClientEngine: HttpClientEngine

internal expect val ApplicationDispatcher: CoroutineDispatcher

internal expect val UIDispatcher: CoroutineDispatcher
