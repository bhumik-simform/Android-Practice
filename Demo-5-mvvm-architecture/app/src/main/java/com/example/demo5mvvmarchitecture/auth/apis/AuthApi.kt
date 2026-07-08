package com.example.demo5mvvmarchitecture.auth.apis

import com.example.demo5mvvmarchitecture.auth.login.model.LoginRequest
import com.example.demo5mvvmarchitecture.auth.login.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}