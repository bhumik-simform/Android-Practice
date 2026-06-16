package com.example.demo4androidwebservices.data.networkServices

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val apiService: TaskApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            json.asConverterFactory(
                "application/json".toMediaType()
            )
        ).build().create(TaskApiService::class.java)
    }
}