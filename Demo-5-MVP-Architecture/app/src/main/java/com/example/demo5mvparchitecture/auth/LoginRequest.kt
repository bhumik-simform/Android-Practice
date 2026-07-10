package com.example.demo5mvparchitecture.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("username")
    val userName: String,
    val password: String
)
