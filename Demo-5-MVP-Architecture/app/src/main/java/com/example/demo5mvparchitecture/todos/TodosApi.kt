package com.example.demo5mvparchitecture.todos

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface TodosApi {
    @GET("todos")
    suspend fun fetchTodosFor(
        @Query("userId") userId: Int
    ): TodosResponse

    @PATCH("todos/{id}")
    suspend fun toggleStatusFor(
        @Path("id")taskId: Int?,
        @Body statusBodyMap: Map<String, Boolean>
    ): TodoTask
}