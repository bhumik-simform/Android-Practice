package com.example.demo5mvvmarchitecture.networkservices

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"

    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory(
                "application/json".toMediaType()
                )
            )
            .build()
    }
    // Genric method which creates retrofit variable which can be used to implement any kind of retrofit interfaces
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}