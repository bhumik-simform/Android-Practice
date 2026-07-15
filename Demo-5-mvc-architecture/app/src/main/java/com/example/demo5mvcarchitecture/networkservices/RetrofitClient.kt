package com.example.demo5mvcarchitecture.networkservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Genric method which creates retrofit variable which can be used to implement any kind of retrofit interfaces
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}