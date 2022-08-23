package com.example.foodike.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.foodike.presentation.cart.Cart
import com.example.foodike.presentation.history.History
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
        homeNavGraph(navController = navController)

    }
}

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.Home.route,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
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
