package com.tasklay.data.domain

import com.tasklay.data.model.ApiResult
import com.tasklay.data.model.TasksResponse
import com.tasklay.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FetchTasksUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(): Flow<ApiResult<TasksResponse>> {
        return flowOf(taskRepository.fetchTasks())
    }
}