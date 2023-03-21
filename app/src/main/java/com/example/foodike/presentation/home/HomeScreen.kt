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
import androidx.compose.material.AppBarDefaults.ContentPadding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodike.R
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.components.RestaurantCard
import com.example.foodike.presentation.components.SearchBar
import com.example.foodike.presentation.home.components.ChipBar
import com.example.foodike.presentation.home.components.FoodikeBottomNavigation
import com.example.foodike.presentation.util.Screen
import java.util.*


@Composable
fun Home(
    scrollState: LazyListState,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    val homeScreenState by viewModel.homeScreenState


    LazyColumn(
        modifier =
        Modifier
            .fillMaxWidth(),
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
            Column(
                modifier = Modifier.padding(8.dp, 0.dp)
            ) {
                SearchBar()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            AdSection(homeScreenState.adsList)
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            RecommendedSection(homeScreenState.foodList)
            Spacer(modifier = Modifier.height(16.dp))
        }
        if (homeScreenState.likedRestaurantList.isNotEmpty()) {
            item {
                FavouriteSection(homeScreenState.likedRestaurantList) {
                    viewModel.onEvent(HomeScreenEvent.SelectRestaurant(it) {
                        navController.navigate(Screen.RestaurantDetails.route)
                    })
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            ChipBar()
        }
        item {
            MainSection()
        }
        items(homeScreenState.restaurantList.size) {
            RestaurantCard(
                restaurant = homeScreenState.restaurantList[it],
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        viewModel.onEvent(HomeScreenEvent.SelectRestaurant(homeScreenState.restaurantList[it]) {
                            navController.navigate(Screen.RestaurantDetails.route)
                        })
                    }
            )
        }
        item {
            ThankYouSection()
        }

    }

}




@Composable
fun MainSection() {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.all_around_you),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

    }
}


@Composable
fun FavouriteSection(
    list: List<Restaurant>,
    onClick: (restaurant: Restaurant) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Text(
            text = stringResource(R.string.order_from_favourites),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))

    }

    LazyRow(
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(list.size) {
            FavouriteCard(restaurant = list[it], modifier = Modifier.clickable {
                onClick(list[it])
            })
        }


    }
}

@Composable
fun FavouriteCard(
    restaurant: Restaurant,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = restaurant.image), contentDescription = stringResource(R.string.restaurant),
            modifier = Modifier
                .size(100.dp, 130.dp)
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp), clip = true),
            contentScale = ContentScale.Crop
        )
        Text(text = restaurant.name)

    }
}

@Composable
fun RecommendedSection(list: List<FoodItem>) {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Text(
            text = stringResource(R.string.recommended_for_you),
            fontSize = 20.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
    LazyRow(
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(list.size) {
            RecommendedCard(foodItem = list[it])
        }
    }
}

@Composable
fun RecommendedCard(
    foodItem: FoodItem
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = foodItem.image), contentDescription = stringResource(R.string.restaurant),
            modifier = Modifier
                .size(80.dp)
                .shadow(elevation = 0.dp, shape = CircleShape, clip = true),
            contentScale = ContentScale.Crop
        )
        Text(text = foodItem.name)
    }
}


@Composable
fun TopSection(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
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
            contentDescription = stringResource(id = R.string.display_picture)
        )


        Row(modifier = Modifier.clickable { }) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = stringResource(R.string.location),

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
    Column(modifier = Modifier.padding(16.dp, 0.dp)) {
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
fun AdSection(
    adsList: List<Advertisement>
) {
    Column()
    {

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(
                start = 8.dp,
                end = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(adsList.size) {
                AdCard(
                    adsList[it]
                )
            }
        }
    }
}


@Composable
fun AdCard(
    ad: Advertisement
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        backgroundColor = ad.color
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
                    text = ad.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = ad.subTitle,
                    fontWeight = FontWeight.Light
                )
            }
            Image(
                painter = painterResource(id = ad.image),
                contentDescription = stringResource(R.string.ad),
                modifier = Modifier
                    .size(150.dp)
                    .weight(0.5f)
            )
        }

    }

}

@Composable
fun ThankYouSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.with),
            modifier = Modifier.alpha(0.5f),
            fontFamily = FontFamily.Cursive,
            fontSize = 24.sp
        )
        Icon(
            imageVector = Icons.Filled.Favorite, contentDescription = stringResource(R.string.love),
            tint = Color.Red,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = stringResource(R.string.from_creator),
            modifier = Modifier.alpha(0.5f),
            fontFamily = FontFamily.Cursive,
            fontSize = 24.sp
        )
    }
}

