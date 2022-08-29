package com.example.foodike.presentation.home

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodike.R
import com.example.foodike.presentation.home.components.FoodikeBottomNavigation
import com.example.foodike.presentation.util.HomeScreenNav
import com.example.foodike.presentation.util.Screen
import java.util.*


@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Cart.route) {
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
                            Spacer(modifier = Modifier.height(32.dp))
                        }
                    }
                }
            }
        }
    ) {
        HomeScreenNav(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    FoodikeBottomNavigation(
        backgroundColor = Color(0xFFE1E1E1)

    ) {
        BottomNavigationItem(
            icon =
            {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                )
            },

            selectedContentColor = Color.Black,
            unselectedContentColor = Color.White,
            alwaysShowLabel = false,
            selected = currentRoute == Screen.Home.route,

            onClick = {
                navController.navigate(Screen.Home.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // re-selecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        )

        Row() {
            Spacer(modifier = Modifier.width(56.dp))
        }


        BottomNavigationItem(
            icon =
            {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_assignment_24),
                    contentDescription = "History",
                )
            },

            selectedContentColor = Color.Black,
            unselectedContentColor = Color.White,
            alwaysShowLabel = false,
            selected = currentRoute == Screen.History.route,
            onClick = {
                navController.navigate(Screen.History.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // re-selecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        )

    }

}

@Composable
fun Home() {
    Column(
        modifier =
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(8.dp))
        GreetingSection()
        Spacer(modifier = Modifier.height(24.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        AdSection()
        Spacer(modifier = Modifier.height(16.dp))
        RecommendedSection()
        Spacer(modifier = Modifier.height(16.dp))
        FavouriteSection()
        MainSection()
    }
}

@Composable
fun MainSection() {
    Text(text = "hjkm")
}

@Composable
fun FavouriteSection() {
    Text(text = "jn")
}

@Composable
fun RecommendedSection() {
    Text(text = "vdv")
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .clickable { },
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Display picture"
        )


        Row(modifier = Modifier.clickable { }) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Location",

                    )
                Text(text = "Guwahati")
            }
        }

    }

}

@Composable
fun GreetingSection(
    userName: String = "Andrew"
) {
    val c: Calendar = Calendar.getInstance()
    val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
    Column(modifier = Modifier.padding(8.dp, 0.dp)) {
        Text(
            text = when (timeOfDay) {
                in 0..11 -> {
                    "Good Morning!"
                }
                in 12..15 -> {
                    "Good Afternoon!"
                }
                else -> {
                    "Good Evening!"
                }
            },
            fontSize = 28.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = userName,
            fontSize = 28.sp,
            fontWeight = FontWeight.Light
        )
    }
}


@Composable
fun AdSection() {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Text(
            text = "Recommended for you...",
            fontSize = 20.sp,

            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row() {
            Card(
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color(0xFFE89191)
            ) {
                Row(Modifier.padding(16.dp)) {
                    Column {
                        Text(text = "Offers for you")
                        Text(text = "Upto 20% discount for you")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.goog_icon),
                        contentDescription = "Ad"
                    )
                }

            }

        }
    }
}

@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = "Search",
                modifier = Modifier.alpha(0.5f)
            )
        },
        leadingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search") },

        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFE1E1E1),
            cursorColor = Color.White,

            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        singleLine = true
    )
}

