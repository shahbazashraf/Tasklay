package com.user.tasklay.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasklay.data.domain.FetchTasksUseCase
import com.tasklay.data.model.ApiResult
import com.tasklay.data.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val fetchTasksUseCase: FetchTasksUseCase
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    // We can use this to display any loading indicator, haven't implemented yet
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    // We can use this to display error e.g. dialog, haven't implemented yet
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun fetchTasks() {
        viewModelScope.launch {
            _loading.value = true
            fetchTasksUseCase().collect { result ->
                _loading.value = false
                when (result) {
                    is ApiResult.Success -> {
                        _tasks.value = result.data?.tasks ?: emptyList()
                    }
                    is ApiResult.Error -> {
                        _error.value = result.message ?: "An unknown error occurred"
                    }
                }
            }
        }
    }
}
