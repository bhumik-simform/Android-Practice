package com.example.demo4androidwebservices.networkServices

import com.example.demo4androidwebservices.crud.data.models.CreateTaskModel
import com.example.demo4androidwebservices.crud.data.models.TaskModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TaskApiService {

    @GET("todos")
    suspend fun fetchTasks(): List<TaskModel>

    @PATCH("todos/{id}")
    suspend fun toggleTasks(@Path("id")taskId: Int, @Body statusMap:Map<String, Boolean>): TaskModel

    @POST("todos")
    suspend fun addNewTask(@Body request: CreateTaskModel): TaskModel

    @DELETE("todos/{id}")
    suspend fun deleteTask(@Path("id")taskId: Int)

    @GET("todos")
    suspend fun filterTasks(
        @Query("userId") userId: Int?,
        @Query("completed") completed: Boolean?
    ): List<TaskModel>
}