package com.example.players.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.players.BaseFragment
import com.example.players.R
import com.example.players.live_data.observe
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : BaseFragment<MainAndroidVM>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[MainAndroidVM::class.java]

        viewModel.kvm.name.observe(this) {
            tv_main.text = it
        }
    }
}