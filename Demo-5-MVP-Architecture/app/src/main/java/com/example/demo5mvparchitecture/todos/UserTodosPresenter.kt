package com.example.demo5mvparchitecture.todos

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class UserTodosPresenter(
    private val view: UserTodosView
) {

    private val repository = TodosRepository()
    private val presenterScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private var userTodos = mutableListOf<TodoTask>()

    fun fetchTodosFor(userId: Int) {
        view.startLoadingState()
        presenterScope.launch {
            try {
                userTodos = repository.fetchTodosFor(userId).toMutableList()
                view.stopLoadingState()
                view.onSuccess(userTodos.toList())
            } catch (e: Exception) {
                view.stopLoadingState()
                view.onError(e.localizedMessage ?: "Unexpected Error Occurred.")
            }
        }
    }

    fun toggleStatusFor(todoItem: TodoTask) {

        val currentStatus = todoItem.isCompleted
        val itemIdx = userTodos.indexOfFirst { todoItem.taskId == it.taskId }
        if (itemIdx == -1) return

        userTodos[itemIdx] = todoItem.copy(isCompleted = currentStatus?.not() ?: false)
        view.onSuccess(userTodos.toList())

        presenterScope.launch {
            try {
                repository.toggleStatusFor(
                    todoItem.taskId,
                    currentStatus = todoItem.isCompleted?.not() ?: false
                )
            } catch (e: Exception) {
                userTodos[itemIdx] = todoItem
                view.onError(
                    e.localizedMessage ?: "Unexpected Error Occurred.",
                    userTodos.toList()
                )
            }
        }
    }
}