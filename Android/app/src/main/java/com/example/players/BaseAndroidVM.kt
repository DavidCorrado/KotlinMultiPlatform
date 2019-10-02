package com.example.players

import androidx.lifecycle.ViewModel

abstract class BaseAndroidVM<VM : BaseViewModel> : ViewModel() {

    abstract val kvm: VM

    fun onAppeared() {
        kvm.onAppeared()
    }

    fun onDisappeared() {
        kvm.onDisappeared()
    }

    override fun onCleared() {
        super.onCleared()
        kvm.onCleared()
    }
}