package com.davidcorrado.todo.shared.feature.tasks

import com.davidcorrado.todo.shared.data.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class TasksKVM {
    private val _todoList = MutableStateFlow<List<Task>>(listOf())

    val toDoList: StateFlow<List<Task>> = _todoList
    suspend fun updateList() = withContext(Dispatchers.Main) {
        _todoList.value = listOf(
            Task("1", "Title1", "Desc1"),
            Task("2", "Title2", "Desc2"),
            Task("3", "Title3", "Desc3")
        )
    }
}