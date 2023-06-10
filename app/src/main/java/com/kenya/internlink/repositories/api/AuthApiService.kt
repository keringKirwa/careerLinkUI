package com.kenya.internlink.repositories.api

import com.kenya.internlink.models.LoginDetails
import com.kenya.internlink.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface AuthApiService {
    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): Response<User>

    @POST("login")
    suspend fun login(@Body loginRequest: LoginDetails): Response<User>
}
