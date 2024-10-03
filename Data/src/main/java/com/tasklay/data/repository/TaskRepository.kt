package com.tasklay.data.repository

import com.tasklay.data.model.ApiResult
import com.tasklay.data.model.TasksResponse

interface TaskRepository {
    suspend fun fetchTasks(): ApiResult<TasksResponse>
}