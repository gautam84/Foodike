package com.example.foodike.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodike.presentation.cart.Cart
import com.example.foodike.presentation.history.History
import com.example.foodike.presentation.home.Home
import com.example.foodike.presentation.home.HomeScreen
import com.example.foodike.presentation.login.LoginScreen
import com.example.foodike.presentation.onboarding.OnBoarding


@Composable
fun SetupNavigation(startDestination: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,route=Graph.Root.route, startDestination = startDestination
    ) {
        composable(
            route = Screen.Onboarding.route,
        ) {
            OnBoarding(navController = navController)
        }
        composable(
            route = Screen.LoginScreen.route,
        ) {
            LoginScreen(navController = navController)
        }

        composable(route = Graph.Home.route) {
            HomeScreen()
        }
    }

}

@Composable
fun HomeScreenNav(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.Home.route,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            Home()
        }
        composable(
            route = Screen.History.route
        ) {
            History()
        }
        composable(
            route = Screen.Cart.route
        ) {
            Cart()
        }
    }
}

