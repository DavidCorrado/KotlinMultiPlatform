package com.davidcorrado.todo.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davidcorrado.todo.androidApp.tasks.TasksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TasksFragment())
                .commitNow()
        }
    }
}
