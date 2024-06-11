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

package com.example.foodike.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodike.R
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.common.getTimeInMins
import java.lang.StringBuilder
import java.util.concurrent.TimeUnit

@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp)
    )
    {
        Row(
            modifier = modifier
                .fillMaxWidth()
                ,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = restaurant.image),
                contentDescription = "Restaurant",
                modifier = Modifier
                    .size(130.dp, 170.dp)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp), clip = true),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = restaurant.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
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
                    Text(text = restaurant.timeInMillis.getTimeInMins())
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
            }

        }
        Spacer(modifier = Modifier.height(18.dp))

    }


}


fun getCustomerInfo(noOfRatings: Int): String {
    return when {
        noOfRatings > 50 -> {
            "50+"
        }
        noOfRatings > 100 -> {
            "100+"
        }
        noOfRatings > 150 -> {
            "150+"
        }
        noOfRatings > 200 -> {
            "200+"
        }
        noOfRatings > 250 -> {
            "250+"
        }
        noOfRatings > 300 -> {
            "300+"
        }
        noOfRatings > 350 -> {
            "350+"
        }
        noOfRatings > 400 -> {
            "400+"
        }
        noOfRatings > 450 -> {
            "450+"
        }
        noOfRatings > 500 -> {
            "500+"
        }
        noOfRatings > 550 -> {
            "550+"
        }
        noOfRatings > 600 -> {
            "600+"
        }
        noOfRatings > 650 -> {
            "650+"
        }
        noOfRatings > 700 -> {
            "700+"
        }
        noOfRatings > 750 -> {
            "750+"
        }
        noOfRatings > 800 -> {
            "800+"
        }
        else -> {
            "1000+"
        }
    }
}



