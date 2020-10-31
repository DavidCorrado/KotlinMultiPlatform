package com.davidcorrado.todo.androidApp.tasks

import androidx.lifecycle.ViewModel
import com.davidcorrado.todo.shared.feature.tasks.TasksKVM
import kotlinx.coroutines.ExperimentalCoroutinesApi

class TasksVM : ViewModel() {
    @ExperimentalCoroutinesApi
    val kvm = TasksKVM()
}