package com.example.demo5mvvmarchitecture.auth.login.model

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
    val name: String
) : Parcelable