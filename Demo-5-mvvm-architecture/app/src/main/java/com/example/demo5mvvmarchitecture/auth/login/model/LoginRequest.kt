package com.example.demo5mvvmarchitecture.auth.login.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("username")
    val userName: String,
    val password: String
)
