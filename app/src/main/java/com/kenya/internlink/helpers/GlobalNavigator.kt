package com.kenya.internlink.helpers

import androidx.compose.runtime.Composable


object
GlobalNavigator {

    @Composable
    fun OnNavigate(screen : String) {
        val navController = Navigation.navControllerLocal.current
        navController.navigate(screen)



    }

}