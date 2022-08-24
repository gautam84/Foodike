package com.example.foodike.presentation.home

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodike.presentation.util.HomeScreenNav



@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {


    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeScreenNav(navController = navController)
    }
}

@Composable
fun Home(){
    Column {
        Text(text = "home")
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation() {

    }

}
