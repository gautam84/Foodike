package com.example.foodike.presentation.util

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodike.presentation.cart.Cart
import com.example.foodike.presentation.history.History
import com.example.foodike.presentation.home.BottomBar
import com.example.foodike.presentation.home.Home
import com.example.foodike.presentation.details.RestaurantDetail
import com.example.foodike.presentation.login.LoginScreen
import com.example.foodike.presentation.onboarding.OnBoarding
import com.example.foodike.presentation.profile.Profile
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
    scrollState: LazyListState
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
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

        composable(
            route = Screen.Home.route
        ) {
            Home(navController = navController, scrollState = scrollState)
        }
        composable(
            route = Screen.History.route
        ) {
            History(navHostController = navController)
        }
        composable(
            route = Screen.Cart.route
        ) {
            Cart(navController = navController)
        }
        composable(
            route = Screen.Profile.route
        ) {
            Profile(navController = navController)
        }

        composable(
            route = Screen.Onboarding.route,
        ) {
            OnBoarding(navController = navController)
        }
        composable(
            route = Screen.RestaurantDetails.route,
        ) {
            RestaurantDetail(
                navController = navController
            )
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetupNavigation(startDestination: String) {

    val navController = rememberNavController()


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    val scrollState = rememberLazyListState()
    val state by remember { derivedStateOf { scrollState.firstVisibleItemIndex == 0 } }


    Scaffold(
        bottomBar = {
            if ((currentRoute == Screen.Home.route || currentRoute == Screen.History.route) && state) {

                Column(
                    modifier = Modifier.padding(115.dp, 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        BottomBar(navController = navController)
                        Column {
                            FloatingActionButton(
                                onClick = {
                                    navController.navigate(Screen.Cart.route)

                                },
                                backgroundColor = MaterialTheme.colors.primary
                            ) {
                                Icon(Icons.Outlined.ShoppingCart, "Cart")
                            }
                            Spacer(modifier = Modifier.height(26.dp))
                        }
                    }
                }
            }
        }
    ) {
        NavigationGraph(
            navController = navController,
            scrollState = scrollState,
            startDestination = startDestination
        )
    }
}



