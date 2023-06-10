package com.kenya.internlink.repositories.interfaces

import com.kenya.internlink.models.ApiResult
import com.kenya.internlink.models.LoginDetails
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
     fun loginUser(loginDetails: LoginDetails): Flow<ApiResult>
}