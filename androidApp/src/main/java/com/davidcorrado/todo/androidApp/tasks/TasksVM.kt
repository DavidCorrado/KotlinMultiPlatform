package com.davidcorrado.todo.androidApp.tasks

import androidx.lifecycle.ViewModel
import com.davidcorrado.todo.shared.feature.tasks.TasksKVM

class TasksVM : ViewModel() {
    val kvm = TasksKVM()
}