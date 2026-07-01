package com.example.demo4androidwebservices.auth

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class LoginResponseModel(
    @SerialName("id")
    val userId: Int,
    val firstName: String,
    val accessToken: String,
    val refreshToken: String
): Parcelable
