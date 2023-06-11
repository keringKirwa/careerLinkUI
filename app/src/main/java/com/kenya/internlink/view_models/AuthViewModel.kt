package com.kenya.internlink.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.kenya.internlink.repositories.repo_implementations.AuthRepositoryImpl
import com.kenya.internlink.helpers.Destinations
import com.kenya.internlink.models.ApiResult
import com.kenya.internlink.models.LoginDetails
import com.kenya.internlink.models.User
import com.kenya.internlink.repositories.interfaces.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AuthViewModel() : ViewModel() {

    private val _loginState = MutableStateFlow<User?>(null)
    val loginState: StateFlow<User?> = _loginState

    fun loginUser(email: String, password: String, navController: NavController ?=null ){

        val loginDetails  = LoginDetails(email, password)

        viewModelScope.launch {
            val authRepository : AuthRepository = AuthRepositoryImpl()

            authRepository.loginUser(loginDetails).collectLatest{

                when(it){
                    is ApiResult.Success -> {
                        Log.d("VIEW_MODEL_SUCCESS::", it.data.toString())

                        _loginState.value= it.data
                        navController?.navigate(Destinations.LandingScreen.routeName)

                        Log.d("VIEW_MODEL_STATE::",_loginState.value.toString())

                    }
                    is ApiResult.Failure -> {
                        Log.d("VIEW-MODEL MESSAGE ", "Request Failure ! ")
                    }

                    is ApiResult.Loading -> {
                        print("Loading ... ")
                    }

                }

            }

        }
    }
}