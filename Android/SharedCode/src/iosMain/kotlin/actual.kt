package com.example.players

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

actual val httpClientEngine: HttpClientEngine by lazy { Ios.create() }