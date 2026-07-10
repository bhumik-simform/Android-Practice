package com.example.demo5mvparchitecture.auth

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LoginPresenter(
    private val view: LoginView
) {
    private val repository = AuthRepository()
    private val presenterScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main)

    fun login(userName: String, password: String) {
        if (userName.isBlank()) {
            view.showError("Please Enter username")
            return
        } else if (password.isBlank()) {
            view.showError("Please Enter password")
            return
        }

        view.showLoadingState()
        val request = LoginRequest(userName, password)

        presenterScope.launch {
            try {
                val response = repository.login(request)
                view.hideLoadingState()
                view.navigateToTodos(response)
            } catch (e: Exception) {
                view.hideLoadingState()
                view.showError(e.localizedMessage ?: "Unexpected Error Occurred")
            }
        }
    }
}