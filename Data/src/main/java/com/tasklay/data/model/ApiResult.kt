package com.tasklay.data.model

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T?) : ApiResult<T>()
    data class Error(val message: String?, val throwable: Throwable? = null) : ApiResult<Nothing>()
}
