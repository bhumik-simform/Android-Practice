package com.example.demo5mvvmarchitecture.todos.usertodos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo5mvvmarchitecture.todos.options.UserTodosUiState
import com.example.demo5mvvmarchitecture.todos.repository.TodosRepository
import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodoTask
import kotlinx.coroutines.launch

class UserTodosViewModel : ViewModel() {
    private val repository = TodosRepository()
    private var userTodos = mutableListOf<TodoTask>()
    private val _uiState = MutableLiveData<UserTodosUiState>()
    val uiState: LiveData<UserTodosUiState>
        get() = _uiState

    fun fetchTodosFor(userId: Int) {
        _uiState.value = UserTodosUiState.LoadingState
        viewModelScope.launch {
            try {
                userTodos = repository.fetchTodosFor(userId).toMutableList()
                _uiState.postValue(UserTodosUiState.OnSuccess(userTodos.toList()))
            } catch (e: Exception) {
                _uiState.postValue(
                    UserTodosUiState.OnError(
                        e.localizedMessage ?: "Unexpected Error Occurred."
                    )
                )
            }
        }
    }

    fun toggleStatusFor(todoItem: TodoTask) {

        val currentStatus = todoItem.isCompleted

        val itemIdx = userTodos.indexOfFirst { todoItem.taskId == it.taskId }
        if (itemIdx == -1) return

        userTodos[itemIdx] = todoItem.copy(isCompleted = currentStatus?.not() ?: false)

        _uiState.postValue(UserTodosUiState.OnSuccess(userTodos.toList()))

        viewModelScope.launch {
            try {
                repository.toggleStatusFor(
                    todoItem.taskId,
                    currentStatus = todoItem.isCompleted?.not() ?: false
                )
            } catch (e: Exception) {
                userTodos[itemIdx] = todoItem
                _uiState.postValue(
                    UserTodosUiState.OnError(
                        e.localizedMessage ?: "Unexpected Error Occurred.",
                        userTodos.toList()
                    )
                )
            }
        }

    }
}