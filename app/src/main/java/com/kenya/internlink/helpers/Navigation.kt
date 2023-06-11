package com.kenya.internlink.helpers

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kenya.internlink.screens.landing_screen.LandingScreen
import com.kenya.internlink.screens.LoginScreen
import com.kenya.internlink.screens.one_oppotunity.SingleOpportunityScreen


object
Navigation {

   @SuppressLint("CompositionLocalNaming")
    val navControllerLocal = staticCompositionLocalOf<NavController> {
        error("CUSTOM ERROR : NAV CONTROLLER NOT CREATED.")
    }

    @Composable
    fun OnSetUpNavigationGraph() {
        val navController = rememberNavController()
        CompositionLocalProvider(navControllerLocal provides navController) {
            NavHost(navController = navController, startDestination = Destinations.SingleProductScreenRoute.routeName) {
                composable(Destinations.SingleProductScreenRoute.routeName) {
                    SingleOpportunityScreen()

                }
                composable(Destinations.LoginScreenRoute.routeName) {
                    LoginScreen()


                }
                composable(Destinations.HomeScreenRoute.routeName) {
                    LandingScreen()

                }
            }
        }
    }

}