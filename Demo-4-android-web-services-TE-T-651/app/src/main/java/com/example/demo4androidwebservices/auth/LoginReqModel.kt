package com.example.demo4androidwebservices.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginReqModel(
    @SerialName("username")
    val userName: String,
    val password: String
)
