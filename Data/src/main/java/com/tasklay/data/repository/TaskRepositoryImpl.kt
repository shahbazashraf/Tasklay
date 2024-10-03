package com.tasklay.data.repository


import com.tasklay.data.model.ApiResult
import com.tasklay.data.model.TasksResponse
import com.tasklay.data.network.ApiService
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TaskRepository {

    override suspend fun fetchTasks(): ApiResult<TasksResponse> {
        return try {
            val response = apiService.fetchTasks()
            if (response.isSuccessful) {
                ApiResult.Success(response.body())
            } else {
                ApiResult.Error(response.message())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResult.Error(e.message, e.cause)
        }
    }
}
