package com.example.demo4androidwebservices.networkServices

import com.example.demo4androidwebservices.auth.LoginReqModel
import com.example.demo4androidwebservices.auth.LoginResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/auth/login")
    suspend fun login(@Body request: LoginReqModel): Response<LoginResponseModel>

}
