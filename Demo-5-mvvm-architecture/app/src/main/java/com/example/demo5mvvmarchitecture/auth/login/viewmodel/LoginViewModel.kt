package com.example.demo5mvvmarchitecture.auth.login.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo5mvvmarchitecture.auth.login.model.LoginRequest
import com.example.demo5mvvmarchitecture.auth.options.LoginUiState
import com.example.demo5mvvmarchitecture.auth.repository.AuthRepository
import com.example.demo5mvvmarchitecture.auth.repository.AuthRepositoryImp
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val repository: AuthRepository = AuthRepositoryImp()
    private val _uiState = MutableLiveData<LoginUiState>()
    val uiState: LiveData<LoginUiState>
        get() = _uiState
    fun login(userName: String, password: String) {
        if (userName.isBlank()) {
            _uiState.value = LoginUiState.UsernameError("Please Enter User Name.")
            return
        } else if (password.isBlank()) {
            _uiState.value = LoginUiState.PasswordError("Please Enter Password.")
            return
        }

        _uiState.value = LoginUiState.OnLoadingState
        val request = LoginRequest(userName, password)

        viewModelScope.launch {
            try {
                val response = repository.login(request)
                _uiState.value = LoginUiState.OnSuccess(response)
            }catch(e: Exception) {
//                Log.e("MyApiAuthError",e.localizedMessage)
                _uiState.value = LoginUiState.OnError(e.localizedMessage?: "Unexpected Error Occurred.")
            }
        }
    }
}