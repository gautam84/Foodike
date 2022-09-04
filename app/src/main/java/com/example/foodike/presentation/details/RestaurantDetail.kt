package com.example.foodike.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.foodike.R
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.components.getCustomerInfo
import com.example.foodike.presentation.components.getTimeInMins
import com.example.foodike.presentation.home.HomeViewModel

@Composable
fun RestaurantDetail(
    name: String,
    navController: NavHostController,
    viewModel: RestaurantDetailViewModel = hiltViewModel()
) {
    var isFavorite by remember { mutableStateOf(false) }



    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back")
            }
            Row {
                IconToggleButton(
                    checked = isFavorite,
                    onCheckedChange = {
                        isFavorite = !isFavorite
                    },
                ) {
                    if (isFavorite) {
                        Icon(
                            imageVector = Icons.Filled.Favorite, contentDescription = "Favourite",
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
        Column(modifier = Modifier.padding(8.dp)) {
            RestaurantDetailCard(
                viewModel.getRestaurantFromName(name)!!
            )

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
            modifier = Modifier.padding(16.dp)
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
            Row {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.outlet_card),
                    contentDescription = "Outlet",
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = restaurant.place)
                    Text(text = "Your Location")
                }
            }
        }
    }
}
