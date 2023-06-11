package com.kenya.internlink.helpers

sealed class Destinations(val routeName: String) {

    object HomeScreenRoute:Destinations("HomeScreen")
    object SingleProductScreenRoute:Destinations("SingleProductScreen")
    object LoginScreenRoute:Destinations("LoginScreen")


}