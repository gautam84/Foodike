/**
 *
 *	MIT License
 *
 *	Copyright (c) 2023 Gautam Hazarika
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 *
 **/

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
import com.example.foodike.presentation.home.components.AdSection
import com.example.foodike.presentation.home.components.ChipBar
import com.example.foodike.presentation.home.components.FavouriteSection
import com.example.foodike.presentation.home.components.FoodikeBottomNavigation
import com.example.foodike.presentation.home.components.GreetingSection
import com.example.foodike.presentation.home.components.MainSection
import com.example.foodike.presentation.home.components.RecommendedSection
import com.example.foodike.presentation.home.components.ThankYouSection
import com.example.foodike.presentation.home.components.TopSection
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











