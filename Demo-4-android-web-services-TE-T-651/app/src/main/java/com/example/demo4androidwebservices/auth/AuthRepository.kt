package com.example.demo4androidwebservices.auth

import com.example.demo4androidwebservices.networkServices.RetrofitClient

class AuthRepository {

    private val apiService = RetrofitClient.authApiService

    suspend fun login(request: LoginReqModel): Result<LoginResponseModel> {
        val response = apiService.login(request)

        return if (
            response.isSuccessful &&
            response.body() != null
        ) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception(response.message()))
        }
    }
}