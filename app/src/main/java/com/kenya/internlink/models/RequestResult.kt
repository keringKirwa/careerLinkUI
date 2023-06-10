package com.kenya.internlink.models

sealed class ApiResult {
    data class Success(val data: User) : ApiResult()
    data class Failure(val message: String) : ApiResult()
    object Loading : ApiResult()
}
