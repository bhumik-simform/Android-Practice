package com.example.demo5mvparchitecture.todos

import kotlinx.serialization.Serializable

@Serializable
data class TodosResponse(
    val todos: List<TodoTask>
)