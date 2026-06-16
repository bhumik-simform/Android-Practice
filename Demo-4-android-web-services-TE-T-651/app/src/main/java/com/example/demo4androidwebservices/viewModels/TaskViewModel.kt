package com.example.demo4androidwebservices.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo4androidwebservices.data.models.TaskModel
import com.example.demo4androidwebservices.data.repositories.TaskRepository
import kotlinx.coroutines.launch


class TaskViewModel: ViewModel() {

    private val repository = TaskRepository()
    private val _uiState = MutableLiveData<TodoHomeUiState>()
    val uiState: LiveData<TodoHomeUiState>
        get() = _uiState

    fun fetchTasks() {
        viewModelScope.launch {

            _uiState.value = TodoHomeUiState.IsLoading

            try {
                val response = repository.fetchTasks()
                _uiState.value = TodoHomeUiState.IsSuccess(response)
            } catch (e: Exception) {
                _uiState.value = TodoHomeUiState.IsError(
                    e.message ?: "Unexpected Error Occurred"
                )
            }
        }
    }


    fun toggleStatus(task: TaskModel) {
        viewModelScope.launch {

        }
    }
}