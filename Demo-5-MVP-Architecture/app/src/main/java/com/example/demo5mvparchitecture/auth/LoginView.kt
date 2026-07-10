package com.example.demo5mvparchitecture.auth

interface LoginView {
    fun showLoadingState()
    fun hideLoadingState()
    fun showError(message: String)
    fun navigateToTodos(userId: LoginResponse)
}