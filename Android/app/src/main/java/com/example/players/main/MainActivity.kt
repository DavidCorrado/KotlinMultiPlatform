package com.example.players.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.players.R
import com.example.players.live_data.observe
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    @InternalAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProviders.of(this)[MainAndroidVM::class.java]

        viewmodel.kvm.name.observe(this) {
            tv_main.text = it
        }
        tv_main.text = createApplicationScreenMessage()

        val playersAPI = PlayersAPI(OkHttpEngine(OkHttpConfig()))
        launch(Dispatchers.Main) {
            try {
                val result = withContext(Dispatchers.IO) { playersAPI.fetchPlayer() }
                Toast.makeText(this@MainActivity, result.name, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
