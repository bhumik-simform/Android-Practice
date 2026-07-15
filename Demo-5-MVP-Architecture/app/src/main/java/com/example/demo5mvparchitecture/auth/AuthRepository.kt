package com.example.demo5mvparchitecture.auth

import com.example.demo5mvparchitecture.network.RetrofitClient

class AuthRepository {
    suspend fun login(request: LoginRequest): LoginResponse {
        return RetrofitClient.create(AuthApi::class.java).login(request)
    }
}