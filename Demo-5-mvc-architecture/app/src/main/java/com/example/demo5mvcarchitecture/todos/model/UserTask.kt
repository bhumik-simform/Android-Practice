package com.example.demo5mvcarchitecture.todos.model

data class UserTask(
    val taskId: Int?,
    val userId: Int?,
    val taskTitle: String?,
    val isCompleted: Boolean?
)