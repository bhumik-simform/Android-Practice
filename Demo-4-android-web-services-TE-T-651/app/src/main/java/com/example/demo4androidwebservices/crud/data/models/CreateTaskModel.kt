package com.example.demo4androidwebservices.crud.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CreateTaskModel(
    val userId: Int,
    val title: String
)
