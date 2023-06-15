package com.kenya.internlink.helpers

sealed class Destinations(val routeName: String) {
    object SignInScreen:Destinations("LoginScreen")

    object HomeScreen:Destinations("HomeScreen")
    object SingleProductScreen:Destinations("SingleProductScreen")

    object SearchScreen:Destinations("SearchScreen")
    object BlogsScreen:Destinations("BlogsScreen")


}