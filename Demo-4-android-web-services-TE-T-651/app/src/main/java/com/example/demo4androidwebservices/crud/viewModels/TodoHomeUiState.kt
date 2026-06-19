package com.example.demo4androidwebservices.crud.viewModels

import com.example.demo4androidwebservices.crud.data.models.TaskModel

sealed class TodoHomeUiState {

    object IsLoading : TodoHomeUiState()

    data class IsSuccess(
        val tasks: List<TaskModel>
    ): TodoHomeUiState()

    data class IsError(
        val message: String
    ): TodoHomeUiState()
}