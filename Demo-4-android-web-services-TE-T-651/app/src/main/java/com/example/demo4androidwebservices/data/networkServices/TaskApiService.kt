package com.example.demo4androidwebservices.data.networkServices

import com.example.demo4androidwebservices.data.models.CreateTaskModel
import com.example.demo4androidwebservices.data.models.TaskModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskApiService {

    @GET("todos")
    suspend fun fetchTasks(): List<TaskModel>

    @PATCH("todos/{id}")
    suspend fun toggleTasks(@Path("id")taskId: Int, @Body statusMap:Map<String, Boolean>): TaskModel

    @POST("todos")
    suspend fun addNewTask(@Body request: CreateTaskModel): TaskModel

    @DELETE("todos/{id}")
    suspend fun deleteTask(@Path("id")taskId: Int)
}