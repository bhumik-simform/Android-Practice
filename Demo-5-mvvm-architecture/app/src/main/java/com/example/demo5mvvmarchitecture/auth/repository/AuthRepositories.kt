package com.example.demo5mvvmarchitecture.auth.repository
import com.example.demo5mvvmarchitecture.auth.api.AuthApi
import com.example.demo5mvvmarchitecture.auth.login.model.LoginRequest
import com.example.demo5mvvmarchitecture.auth.login.model.LoginResponse
import com.example.demo5mvvmarchitecture.networkservices.RetrofitClient

interface AuthRepository {
    suspend fun login(request: LoginRequest): LoginResponse
}

class AuthRepositoryImp: AuthRepository {

    private val networkService = RetrofitClient.create(AuthApi::class.java)

    override suspend fun login(request: LoginRequest): LoginResponse {
       return networkService.login(request)
    }
}