package com.example.demo5mvvmarchitecture.todos.usertodos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodoTask(
    @SerialName("id")
    val taskId: Int?,
    val userId: Int?,
    @SerialName("todo")
    val taskTitle: String?,
    @SerialName("completed")
    val isCompleted: Boolean?
)
