package com.example.demo4androidwebservices.crud.data.models

import kotlinx.serialization.Serializable
@Serializable
data class TaskModel(
    val id: Int,
    val userId: Int,
    val title: String,
    var completed: Boolean = false
)