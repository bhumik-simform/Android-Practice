package com.example.demo5mvparchitecture.todos

interface UserTodosView {
    fun startLoadingState()
    fun stopLoadingState()
    fun onError(message: String, defaultData: List<TodoTask>? = null)
    fun onSuccess(data: List<TodoTask>)
}