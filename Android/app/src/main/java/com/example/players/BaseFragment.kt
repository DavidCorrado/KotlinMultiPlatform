package com.example.players

import androidx.fragment.app.Fragment

open class BaseFragment<VM: BaseAndroidVM<*>>: Fragment() {

    protected lateinit var viewModel: VM

    override fun onResume() {
        super.onResume()
        viewModel.onAppeared()
    }

    override fun onPause() {
        viewModel.onDisappeared()
        super.onPause()
    }
}