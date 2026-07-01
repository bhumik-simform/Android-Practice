package com.example.demo4androidwebservices.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val repository = AuthRepository()
    private val _uiState = MutableLiveData<LoginUiState>()
    val uiState: LiveData<LoginUiState>
        get() = _uiState

    fun login(userName: String, password: String) {

        _uiState.value = LoginUiState.OnLoadingState()

        val request = LoginReqModel(userName, password)

        viewModelScope.launch {

            val result = repository.login(request)

            result
                .onSuccess { loginResponse ->
                    _uiState.value = LoginUiState.OnSuccess(loginResponse)
                }
                .onFailure { exception ->
                    _uiState.value = LoginUiState.OnError(
                        exception.message ?: "Unexpected error occurred."
                    )
                }
        }
    }
}