package com.example.demo5mvvmarchitecture.todos.usertodos.model

import kotlinx.serialization.Serializable

@Serializable
data class TodosResponse(
    val todos: List<TodoTask>
)
