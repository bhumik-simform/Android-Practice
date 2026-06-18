package com.example.demo4androidwebservices.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CreateTaskModel(
    val userId: Int,
    val title: String
)
