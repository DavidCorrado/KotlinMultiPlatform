package com.example.players

import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier

fun addLogging() {
    Napier.base(DebugAntilog())
}