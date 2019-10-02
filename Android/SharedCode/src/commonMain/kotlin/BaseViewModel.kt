package com.example.players

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Main

    open fun onAppeared() {

    }

    open fun onDisappeared() {

    }

    open fun onCleared() {
        job.cancel()
    }
}