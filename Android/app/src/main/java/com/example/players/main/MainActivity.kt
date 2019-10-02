package com.example.players.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.players.R
import com.example.players.observe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProviders.of(this)[MainAndroidVM::class.java]

        viewmodel.kvm.name.observe(this) {
            tv_main.text = it
        }
    }
}
