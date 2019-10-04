package com.example.players

import android.app.Application
import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
    }
}