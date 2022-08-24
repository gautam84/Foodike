package com.example.foodike.presentation.util

sealed class Screen(val route: String) {
    object Onboarding : Screen(route = "onboarding")
    object LoginScreen : Screen(route = "login_screen")
    object Home : Screen(route = "home_screen")
    object History : Screen(route = "history")
    object Cart : Screen(route = "cart")
}
