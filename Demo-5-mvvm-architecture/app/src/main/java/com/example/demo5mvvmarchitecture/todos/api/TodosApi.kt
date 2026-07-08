package com.example.demo5mvvmarchitecture.todos.api

import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TodosApi {
    @GET("todos")
    suspend fun fetchTodosFor(
        @Query("userId") userId: Int
    ): TodosResponse
}