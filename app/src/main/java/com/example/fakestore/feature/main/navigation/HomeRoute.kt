package com.example.fakestore.feature.main.navigation

sealed class HomeRoute(val route:String){
    object CategoryScreen: HomeRoute("category")
}
