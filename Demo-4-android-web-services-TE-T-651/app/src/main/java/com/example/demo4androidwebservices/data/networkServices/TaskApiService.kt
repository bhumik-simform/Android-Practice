package com.example.demo4androidwebservices.data.networkServices

import com.example.demo4androidwebservices.data.models.TaskModel
import retrofit2.http.GET

interface TaskApiService {

    @GET("todos")
    suspend fun fetchTasks(): List<TaskModel>
}