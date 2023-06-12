package com.kenya.internlink.helpers

sealed class Destinations(val routeName: String) {

    object LandingScreen:Destinations("HomeScreen")
    object SingleProductScreen:Destinations("SingleProductScreen")
    object SignInScreen:Destinations("LoginScreen")
    object SearchScreen:Destinations("SearchScreen")


}