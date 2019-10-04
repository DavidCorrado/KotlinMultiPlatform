package com.example.players

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val httpClientEngine: HttpClientEngine by lazy {
    OkHttp.create {}
}

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default

internal actual val UIDispatcher: CoroutineDispatcher = Dispatchers.Main