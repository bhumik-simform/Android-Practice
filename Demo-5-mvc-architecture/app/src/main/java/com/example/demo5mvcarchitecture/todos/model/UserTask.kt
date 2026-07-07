package com.example.demo5mvcarchitecture.todos.model

import com.google.gson.annotations.SerializedName
data class UserTask(
    @SerializedName("id")
    val taskId: Int?,
    val userId: Int?,
    @SerializedName("todo")
    val taskTitle: String?,
    @SerializedName("completed")
    val isCompleted: Boolean?
)