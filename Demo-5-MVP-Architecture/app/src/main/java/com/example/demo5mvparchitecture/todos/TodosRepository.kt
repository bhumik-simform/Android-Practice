package com.example.demo5mvparchitecture.todos

import com.example.demo5mvparchitecture.network.RetrofitClient

class TodosRepository {
    private val networkService = RetrofitClient.create(TodosApi::class.java)
    suspend fun fetchTodosFor(userId: Int): List<TodoTask> {
        return networkService.fetchTodosFor(userId).todos
    }

    suspend fun toggleStatusFor(taskId: Int?, currentStatus: Boolean): TodoTask {
        val updatedStatusBody = mapOf("completed" to currentStatus)
        return networkService.toggleStatusFor(taskId, updatedStatusBody)
    }
}