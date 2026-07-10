package com.example.demo5mvparchitecture.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Parcelize
@Serializable
data class LoginResponse(
    @SerialName("id")
    val userId: Int,
    @SerialName("firstName")
    val userName: String
) : Parcelable
