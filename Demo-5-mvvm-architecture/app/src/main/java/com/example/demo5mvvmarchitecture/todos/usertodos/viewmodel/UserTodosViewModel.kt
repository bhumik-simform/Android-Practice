package com.example.demo5mvvmarchitecture.todos.usertodos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo5mvvmarchitecture.todos.options.UserTodosUiState
import com.example.demo5mvvmarchitecture.todos.repository.TodosRepository
import com.example.demo5mvvmarchitecture.todos.usertodos.model.TodoTask
import kotlinx.coroutines.launch

class UserTodosViewModel: ViewModel() {
    private val repository = TodosRepository()
    private var userTodos = listOf<TodoTask>()
    private val _uiState = MutableLiveData<UserTodosUiState>()
    val uiState: LiveData<UserTodosUiState>
        get() = _uiState
    fun fetchTodosFor(userId: Int) {
        _uiState.value = UserTodosUiState.LoadingState
        viewModelScope.launch {
            try {
                userTodos = repository.fetchTodosFor(userId)
//                Log.d("MyApiTodoResponse",userTodos.toString())
                _uiState.value = UserTodosUiState.OnSuccess(userTodos)
            } catch(e: Exception) {
//                Log.e("MyApiTodoError",e.localizedMessage)
                _uiState.value = UserTodosUiState.OnError(e.localizedMessage?: "Unexpected Error Occurred.")
            }
        }
    }
}