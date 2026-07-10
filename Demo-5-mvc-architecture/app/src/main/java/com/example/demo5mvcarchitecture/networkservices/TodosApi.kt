package com.example.demo5mvcarchitecture.networkservices

import com.example.demo5mvcarchitecture.todos.model.TodosResponse
import retrofit2.http.GET

interface TodosApi {
    @GET("todos")
    suspend fun fetchTodosTask(): TodosResponse
}