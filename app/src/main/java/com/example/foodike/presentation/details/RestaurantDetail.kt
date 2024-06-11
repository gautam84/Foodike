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

package com.example.foodike.presentation.details

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.presentation.details.components.MenuItemCard
import com.example.foodike.presentation.details.components.RestaurantDetailCard
import com.example.foodike.presentation.util.Screen

@Composable
fun RestaurantDetail(
    navController: NavHostController,
    viewModel: RestaurantDetailViewModel = hiltViewModel()
) {

    val detailScreenState by viewModel.detailScreenState


    val rotationState by animateFloatAsState(
        targetValue = if (detailScreenState.recommendedExpandedState) 180f else 0f
    )

    val rotationStateNonVeg by animateFloatAsState(
        targetValue = if (detailScreenState.nonVegExpandedState) 180f else 0f
    )

    val rotationStateVeg by animateFloatAsState(
        targetValue = if (detailScreenState.vegExpandedState) 180f else 0f
    )


    Box(contentAlignment = Alignment.BottomEnd) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = stringResource(R.string.favourite)
                        )
                    }
                    Row {
                        IconToggleButton(
                            checked = detailScreenState.isLiked,
                            onCheckedChange = {
                                viewModel.onEvent(DetailScreenEvent.ToggleLikedStatus)
                            },
                        ) {
                            if (detailScreenState.isLiked) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = stringResource(R.string.favourite),
                                    tint = Color.Red
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = stringResource(R.string.favourite)
                                )
                            }

                        }
                        IconButton(onClick = {

                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Share,
                                contentDescription = stringResource(
                                    R.string.share
                                )
                            )
                        }

                    }
                }
            }
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    RestaurantDetailCard(
                        detailScreenState.restaurant!!
                    )

                }
            }
            val recommendedList =
                detailScreenState.recommendedList




            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        modifier = Modifier
                            .weight(6f),
                        text = stringResource(R.string.recommended),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(ContentAlpha.medium)
                            .rotate(rotationState),
                        onClick = {
                            viewModel.onEvent(DetailScreenEvent.ToggleRecommendedSectionExpandedState)
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = stringResource(R.string.drop_down_arrow)
                        )
                    }

                }

            }
            if (detailScreenState.recommendedExpandedState) {

                items(recommendedList.size) {
                    MenuItemCard(
                        menuItem = recommendedList[it].menuItem,


                        )
                    if (it != (recommendedList.size - 1)) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp, 0.dp)
                        )
                    }
                }


            }

            val nonVegList = detailScreenState.menuList.filter {
                !it.menuItem.isVegetarian
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        modifier = Modifier
                            .weight(6f),
                        text = stringResource(R.string.non_vegetarian),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(ContentAlpha.medium)
                            .rotate(rotationStateNonVeg),
                        onClick = {
                            viewModel.onEvent(DetailScreenEvent.ToggleNonVegSectionExpandedState)
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = stringResource(R.string.drop_down_arrow)
                        )
                    }

                }

            }
            if (detailScreenState.nonVegExpandedState) {

                items(nonVegList.size) {
                    MenuItemCard(
                        menuItem = nonVegList[it].menuItem,
                    )
                    if (it != (nonVegList.size - 1)) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp, 0.dp)
                        )
                    }
                }
            }

            val vegList = detailScreenState.menuList.filter {
                it.menuItem.isVegetarian
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp, 0.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {
                    Text(
                        modifier = Modifier
                            .weight(6f),
                        text = stringResource(R.string.vegetarian),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(
                        modifier = Modifier
                            .weight(1f)
                            .alpha(ContentAlpha.medium)
                            .rotate(rotationStateVeg),
                        onClick = {
                            viewModel.onEvent(DetailScreenEvent.ToggleVegSectionExpandedState)
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = stringResource(R.string.drop_down_arrow)
                        )
                    }

                }

            }
            if (detailScreenState.vegExpandedState) {

                items(vegList.size) {
                    MenuItemCard(
                        menuItem = vegList[it].menuItem,
                    )
                    if (it != (vegList.size - 1)) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp, 0.dp)
                        )
                    }
                }


            }


        }

        if (detailScreenState.menuList.sumOf { it.noOfItems } != 0) {
            Column(modifier = Modifier.padding(16.dp)) {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.Cart.route)

                    },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(Icons.Outlined.ShoppingCart, stringResource(R.string.cart))
                }
            }
        }
    }
}



