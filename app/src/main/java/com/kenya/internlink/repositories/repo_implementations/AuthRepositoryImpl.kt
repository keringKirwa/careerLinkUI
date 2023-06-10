package com.kenya.internlink.repositories.repo_implementations

import android.util.Log
import com.kenya.internlink.models.ApiResult
import com.kenya.internlink.models.LoginDetails
import com.kenya.internlink.repositories.api.AuthApiService
import com.kenya.internlink.repositories.interfaces.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AuthRepositoryImpl() : AuthRepository {


    override fun loginUser(loginDetails: LoginDetails): Flow<ApiResult> {
        return flow{

            val retrofit = Retrofit.Builder()
                .baseUrl("/home/login")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(AuthApiService::class.java)
            emit(ApiResult.Loading);


            val res = apiService.login(loginDetails)

            res.body()?.let {
                emit(ApiResult.Success(it))
            }


        }.catch {
            emit(ApiResult.Failure("Something went wrong, please try again later"))
            Log.d("Auth Repo Layer:: ", "No endpoint available: emitting Success Instead.")
            emit(ApiResult.Failure("Emitted Failure : only for testing reasons"))

        }

    }
}
