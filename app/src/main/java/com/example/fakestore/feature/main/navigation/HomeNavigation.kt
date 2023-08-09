package com.example.fakestore.feature.main.navigation

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fakestore.feature.main.category.CategoriesScreen
import com.example.fakestore.feature.main.category.CategoryViewModel
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory

@Composable
fun HomeNavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeRoute.CategoryScreen.route) {
        composable(route = HomeRoute.CategoryScreen.route) { navBackStackEntry ->
            val viewModel: CategoryViewModel = hiltViewModel()//(activity,"MainActivity", HiltViewModelFactory(LocalContext.current, navBackStackEntry))
            CategoriesScreen(navController, viewModel = viewModel)
        }


    }

}
