package com.tasklay.data.network

import com.tasklay.data.model.TasksResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    suspend fun fetchTasks(): Response<TasksResponse>
}
