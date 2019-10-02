package com.example.players.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.players.BaseFragment
import com.example.players.R
import com.example.players.api.PlayersAPI
import com.example.players.live_data.observe
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import io.ktor.util.InternalAPI
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainFragment : BaseFragment<MainAndroidVM>(), CoroutineScope {


    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    @InternalAPI
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[MainAndroidVM::class.java]

        viewModel.kvm.name.observe(this) {
            tv_main.text = it
        }
        val playersAPI = PlayersAPI(OkHttpEngine(OkHttpConfig()))
        launch(Dispatchers.Main) {
            try {
                val result = withContext(Dispatchers.IO) { playersAPI.fetchPlayer() }
                Toast.makeText(context, result.name, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }


}