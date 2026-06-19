package com.example.demo4androidwebservices.crud.data.repositories

import com.example.demo4androidwebservices.crud.data.models.CreateTaskModel
import com.example.demo4androidwebservices.crud.data.models.TaskModel
import com.example.demo4androidwebservices.crud.data.networkServices.RetrofitClient


class TaskRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun fetchTasks(): List<TaskModel> {
        return apiService.fetchTasks().sortedBy { it.id }
    }

    suspend fun toggleStatus(taskId: Int, currentStatus: Boolean): TaskModel {
        val updatedStatus = mapOf("completed" to currentStatus)
        return apiService.toggleTasks(taskId, updatedStatus)
    }

    suspend fun addTask(requestedTask: CreateTaskModel): TaskModel {
        return apiService.addNewTask(requestedTask)
    }

    suspend fun deleteTask(taskId: Int) {
        apiService.deleteTask(taskId)
    }

    suspend fun applyFilter(userId: Int?, completed: Boolean?): List<TaskModel> {
        return apiService.filterTasks(userId, completed)
    }
}