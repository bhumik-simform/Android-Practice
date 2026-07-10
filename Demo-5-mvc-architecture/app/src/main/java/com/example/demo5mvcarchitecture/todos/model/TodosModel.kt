package com.example.demo5mvcarchitecture.todos.model

import com.example.demo5mvcarchitecture.networkservices.RetrofitClient
import com.example.demo5mvcarchitecture.networkservices.TodosApi

object TodosModel {

    private var userTasks = listOf<UserTask>()
    suspend fun fetchTask(): List<UserTask> {
        userTasks = RetrofitClient
            .create(TodosApi::class.java) // Create and return RetrofitClient which return implemented interface according to interface class
            .fetchTodosTask() // Method to initiate network call
            .todos // Unwrapping response came from Network call

        return  userTasks
    }
}