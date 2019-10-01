package com.example.players.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.players.R
import com.example.players.createApplicationScreenMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text = createApplicationScreenMessage()
    }
}
