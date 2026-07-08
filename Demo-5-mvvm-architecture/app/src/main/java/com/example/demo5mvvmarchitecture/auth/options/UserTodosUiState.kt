package com.example.demo5mvvmarchitecture.auth.options

import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodoTask

sealed class UserTodosUiState {
    data object LoadingState: UserTodosUiState()
    data class OnSuccess(val data: List<TodoTask>): UserTodosUiState()
    data class OnError(val message: String): UserTodosUiState()
}
