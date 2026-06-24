package com.example.demo4androidwebservices.auth

sealed class LoginUiState {
    class OnLoadingState: LoginUiState()
    class OnSuccess(val data: LoginResponseModel): LoginUiState()
    class OnError(val message: String): LoginUiState()
}