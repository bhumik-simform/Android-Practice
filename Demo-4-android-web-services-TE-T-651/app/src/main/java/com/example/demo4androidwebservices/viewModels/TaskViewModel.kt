package com.example.demo4androidwebservices.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo4androidwebservices.data.models.TaskModel
import com.example.demo4androidwebservices.data.repositories.TaskRepository
import kotlinx.coroutines.launch


class TaskViewModel : ViewModel() {

    private val repository = TaskRepository()
    private val _tasks = MutableLiveData<List<TaskModel>>()
    val tasks: LiveData<List<TaskModel>>
        get() = _tasks

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean>
        get() = _loadingState

    private val _onError = MutableLiveData<String>()
    val onError: LiveData<String>
        get() = _onError

    fun fetchTasks() {

        _loadingState.value = true
        _onError.value = ""

        viewModelScope.launch {
            try {
                _tasks.value = repository.fetchTasks()
                _loadingState.value = false
            } catch (e: Exception) {
                _onError.value = e.message.toString()
                _loadingState.value = false
            }
        }
    }


    fun toggleStatus(task: TaskModel) {

        val currentStatus = task.completed
        val currentList = _tasks.value?.toMutableList() ?: return

        val idx = currentList.indexOfFirst { it.id == task.id }
        if (idx == -1) return

        currentList[idx] = task.copy(completed = !currentStatus)
        _tasks.value = currentList


        viewModelScope.launch {

            try {
                val newTask =
                    repository.toggleStatus(taskId = task.id, currentStatus = !task.completed)
                Log.d("Meow", "Response: $newTask")

            } catch (e: Exception) {

                val failedList = _tasks.value?.toMutableList() ?: return@launch
                failedList[idx] = task
                _tasks.value = failedList
                _onError.value = e.message.toString()
                Log.e("Meow",e.message.toString())
            }
        }
    }

    fun addTask() {

    }
}

//            Log.d("MyToggle", "Clicked Item: $task")

//            Log.d("MyToggle", "Current Item Status: $currentStatus")
//            Log.d("MyToggle", "Before in list ${ _tasks.value?.elementAt(task.id) }")
//            Log.d("MyToggle", "After in list: ${ _tasks.value?.elementAt(task.id) }")

/*
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
 */

