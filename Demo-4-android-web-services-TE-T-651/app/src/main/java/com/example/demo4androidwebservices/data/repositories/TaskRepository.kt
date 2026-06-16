package com.example.demo4androidwebservices.data.repositories

import com.example.demo4androidwebservices.data.models.TaskModel
import com.example.demo4androidwebservices.data.networkServices.RetrofitClient


class TaskRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun fetchTasks(): List<TaskModel> {
        return apiService.fetchTasks().sortedBy { it.id }
    }

}