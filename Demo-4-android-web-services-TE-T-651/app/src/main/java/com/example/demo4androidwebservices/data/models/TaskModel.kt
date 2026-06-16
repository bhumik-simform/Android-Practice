package com.example.demo4androidwebservices.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TaskModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)