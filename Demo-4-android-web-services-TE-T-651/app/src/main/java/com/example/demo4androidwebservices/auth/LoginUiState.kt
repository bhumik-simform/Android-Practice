package com.example.demo4androidwebservices.auth

import android.telephony.IccOpenLogicalChannelResponse

sealed class LoginUiState {
    class OnLoadingState: LoginUiState()
    class OnSuccess(val data: LoginResponseModel): LoginUiState()
    class OnError(val message: String): LoginUiState()
}