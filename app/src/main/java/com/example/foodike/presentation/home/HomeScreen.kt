package com.example.foodike.presentation.home

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodike.R
import com.example.foodike.presentation.components.RestaurantCard
import com.example.foodike.presentation.components.SearchBar
import com.example.foodike.presentation.home.components.ChipBar
import com.example.foodike.presentation.home.components.FoodikeBottomNavigation
import com.example.foodike.presentation.util.Screen
import java.util.*


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
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
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
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
            }
        )

    }

}

@Composable
fun Home(scrollState: LazyListState, navController: NavHostController) {

    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    LazyColumn(
        modifier =
        Modifier.padding(8.dp, 0.dp),
        state = scrollState,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            TopSection(navController = navController)
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            GreetingSection()
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            AdSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            RecommendedSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            FavouriteSection()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            MainSection()
        }
        item {
            RestaurantCard(
                name = "Saffron Express",
                rating = "4.6",
                customers = "100+",
                time = "59 mins",
                variety = "North Indian, Chinese, Tandoori",
                place = "Mahabhairab"
            )
            RestaurantCard(
                name = "KF",
                rating = "4.2",
                customers = "50+",
                time = "28 mins",
                variety = "Biryani, Chinese, Tandoori",
                place = "Ketekibari"
            )

        }

    }

}

@Composable
fun MainSection() {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Spacer(modifier = Modifier.height(8.dp))
        ChipBar()
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "All around you..",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

    }
}


@Composable
fun FavouriteSection() {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Text(
            text = "Order from favourites..",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            FavouriteCard()
            Spacer(modifier = Modifier.width(12.dp))
            FavouriteCard()
            Spacer(modifier = Modifier.width(12.dp))
            FavouriteCard()


        }
    }
}

@Composable
fun FavouriteCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.chinese), contentDescription = "Restaurant",
            modifier = Modifier
                .size(100.dp, 130.dp)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp), clip = true),
            contentScale = ContentScale.Crop
        )
        Text(text = "Burger")

    }
}

@Composable
fun RecommendedSection() {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Text(
            text = "Recommended for you...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            RecommendedCard()
            Spacer(modifier = Modifier.width(8.dp))
            RecommendedCard()
            Spacer(modifier = Modifier.width(8.dp))
            RecommendedCard()
        }
    }
}

@Composable
fun RecommendedCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.burger), contentDescription = "Restaurant",
            modifier = Modifier
                .size(80.dp)
                .shadow(elevation = 0.dp, shape = CircleShape, clip = true),
            contentScale = ContentScale.Crop
        )
        Text(text = "Burger")
    }
}


@Composable
fun TopSection(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .clickable {
                    navController.navigate(Screen.Profile.route)
                },
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

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
        ) {
            item {
                AdCard(
                    titleText = "Offers for you",
                    contentText = "Upto 20% discount for you",
                    color = Color(0xFFE89191)

                )
                Spacer(modifier = Modifier.width(8.dp))
                AdCard(
                    titleText = "Free delivery",
                    contentText = "Free delivery for selected restaurants...",
                    color = Color(0xFFDBE891)

                )
            }


        }
    }
}


@Composable
fun AdCard(
    titleText: String,
    contentText: String,
    color: Color
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        backgroundColor = color
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .size(210.dp, 140.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = titleText,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = contentText,
                    fontWeight = FontWeight.Light
                )
            }
            Image(
                painter = painterResource(id = R.drawable.chinese_bowl),
                contentDescription = "Ad",
                modifier = Modifier
                    .size(150.dp)
                    .weight(0.5f)
            )
        }

    }
}

