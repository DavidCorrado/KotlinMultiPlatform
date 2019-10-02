package com.example.players.main

import com.example.players.BaseAndroidVM

class MainAndroidVM : BaseAndroidVM<MainVM>() {
    override val kvm = MainVM()
}