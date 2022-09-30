package com.example.foodike.presentation.details

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.domain.model.MenuItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.components.getCustomerInfo
import com.example.foodike.presentation.components.getTimeInMins
import com.example.foodike.presentation.util.Screen

@Composable
fun RestaurantDetail(
    name: String,
    navController: NavHostController,
    viewModel: RestaurantDetailViewModel = hiltViewModel()
) {

    viewModel.onEvent(DetailScreenEvent.SetRestaurant(name))


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
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                    Row {
                        IconToggleButton(
                            checked = detailScreenState.isLiked,
                            onCheckedChange = {
                                if (detailScreenState.isLiked) {
//                                    viewModel.removeRestaurant(detailScreenState.restaurant!!)
//                                    viewModel.setLikeStatus(detailScreenState.restaurant!!)

                                } else {
//                                    viewModel.addRestaurant(detailScreenState.restaurant!!)
//                                    viewModel.setLikeStatus(detailScreenState.restaurant!!)
                                }

                            },
                        ) {
                            if (detailScreenState.isLiked) {
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "Favourite",
                                    tint = Color.Red
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Favourite"
                                )
                            }

                        }
                        IconButton(onClick = {

                        }) {
                            Icon(imageVector = Icons.Outlined.Share, contentDescription = "Share")
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
                detailScreenState.menuList.shuffled().dropLast(detailScreenState.restaurant!!.menu.size - 5)




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
                        text = "Recommended",
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
                            contentDescription = "Drop-Down Arrow"
                        )
                    }

                }

            }
            if (detailScreenState.recommendedExpandedState) {

                items(recommendedList.size) {
                    MenuItemCard(
                        menuItem = recommendedList[it].menuItem,
                        noOfItems = recommendedList[it].noOfItems,
                        onDecreaseClick = { viewModel.decreaseQuantity(recommendedList[it]) },
                        onIncreaseClick = { viewModel.increaseQuantity(recommendedList[it]) }


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
                        text = "Non-Vegetarian",
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
                            contentDescription = "Drop-Down Arrow"
                        )
                    }

                }

            }
            if (detailScreenState.nonVegExpandedState) {

                items(nonVegList.size) {
                    MenuItemCard(
                        menuItem = nonVegList[it].menuItem,
                        noOfItems = nonVegList[it].noOfItems,
                        onDecreaseClick = { viewModel.decreaseQuantity(recommendedList[it]) },
                        onIncreaseClick = { viewModel.increaseQuantity(recommendedList[it]) }
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
                        text = "Vegetarian",
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
                            contentDescription = "Drop-Down Arrow"
                        )
                    }

                }

            }
            if (detailScreenState.vegExpandedState) {

                items(vegList.size) {
                    MenuItemCard(
                        menuItem = vegList[it].menuItem,
                        noOfItems = vegList[it].noOfItems,
                        onDecreaseClick = { viewModel.decreaseQuantity(recommendedList[it]) },
                        onIncreaseClick = { viewModel.increaseQuantity(recommendedList[it]) }
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
                    Icon(Icons.Outlined.ShoppingCart, "Cart")
                }
            }
        }
    }
}


@Composable
fun MenuItemCard(
    menuItem: MenuItem,
    noOfItems: Int,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit

) {
    Row(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Column(
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (menuItem.isVegetarian) {
                    Image(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.ic_veg),
                        contentDescription = "Vegetarian"
                    )
                } else {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.ic_non_veg),
                        contentDescription = "Non-Vegetarian"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = menuItem.dish)
            }

            Text(text = "  $  ${menuItem.price}", overflow = TextOverflow.Ellipsis)
            Row {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Rating",
                    tint = Color(0xFFFF7A00)
                )
                Text(text = menuItem.rating.toString())
                Text(
                    text = " · ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = menuItem.noOfRatings.toString() + " ratings",
                )
            }
        }

        if (
            noOfItems == 0
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row {
                    Text(
                        text = "Add",
                        modifier = Modifier.clickable {
                            onIncreaseClick()


                        },
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .border(
                            BorderStroke(1.dp, Color.Black.copy(0.5f)),
                            MaterialTheme.shapes.medium
                        ),
                    shape = MaterialTheme.shapes.medium,
                    color = Color.White,
                    contentColor = MaterialTheme.colors.primary
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            onDecreaseClick()

                        }) {
                            Icon(
                                imageVector = Icons.Default.Remove,
                                contentDescription = "Subtract",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        Text(text = noOfItems.toString())
                        IconButton(onClick = {
                            onIncreaseClick()

                        }) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add",
                                modifier = Modifier.size(16.dp)

                            )
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun RestaurantDetailCard(
    restaurant: Restaurant
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Color(0xFFC6FDB3)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
        ) {
            Text(
                text = restaurant.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    modifier = Modifier
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))

                Text(text = "${restaurant.rating}(${getCustomerInfo(restaurant.noOfRatings)}) ")
                Text(
                    text = "·",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = " ${getTimeInMins(restaurant.timeInMillis)} ")
                Text(
                    text = "·",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = " $${restaurant.averagePrice} ")

            }
            Text(
                text = restaurant.variety,
                modifier = Modifier.alpha(0.5f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Text(
                text = restaurant.place,
                modifier = Modifier.alpha(0.5f),
            )

            Row(
                modifier = Modifier.padding(0.dp, 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.outlet_card),
                    contentDescription = "Outlet",
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            text = "Outlet:",
                            fontSize = 16.sp
                        )
                    }
                    Row {
                        Text(text = getTimeInMins(restaurant.timeInMillis))
                    }
                }
                Spacer(modifier = Modifier.width(24.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        Text(
                            text = restaurant.place, modifier = Modifier.alpha(0.5f),
                        )
                    }
                    Row {
                        Text(
                            text = "Your Location", modifier = Modifier.alpha(0.5f),
                        )
                    }
                }
            }
        }
    }
}
