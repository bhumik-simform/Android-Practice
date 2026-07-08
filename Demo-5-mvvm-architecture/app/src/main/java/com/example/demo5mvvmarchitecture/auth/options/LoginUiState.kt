package com.example.demo5mvvmarchitecture.auth.options

import androidx.annotation.StringRes
import com.example.demo5mvvmarchitecture.auth.login.model.LoginResponse

sealed class LoginUiState {
    data object OnLoadingState: LoginUiState()
    data class OnSuccess(val data: LoginResponse): LoginUiState()
    data class OnError(val message: String): LoginUiState()
    data class  UsernameError(val message: String): LoginUiState()
    data class  PasswordError(val message: String): LoginUiState()
}