package com.kenya.internlink.helpers

sealed class Destinations(val routeName: String) {

    object HomeScreenRoute:Destinations("HomeScreen")
    object LoginScreenRoute:Destinations("LoginScreen")


}