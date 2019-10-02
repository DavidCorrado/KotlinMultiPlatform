package com.example.players.main

import com.example.players.BaseAndroidVM
import com.example.players.api.PlayersAPI
import io.ktor.util.InternalAPI

class MainAndroidVM : BaseAndroidVM<MainVM>() {
    @InternalAPI
    override val kvm = MainVM(PlayersAPI())
}