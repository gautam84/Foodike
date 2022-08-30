package com.example.foodike.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodike.R

@Composable
fun RestaurantCard(
    name: String,
    rating: String,
    customers: String,
    time: String,
    variety: String,
    place: String
) {
    Column(modifier = Modifier.padding(8.dp, 0.dp))
    {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.burger),
                contentDescription = "Restaurant",
                modifier = Modifier
                    .size(130.dp, 170.dp)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(8.dp), clip = true),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = name,
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

                    Text(text = "$rating($customers) ")
                    Text(
                        text = "·",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = " $time")
                }
                Text(
                    text = variety,
                    modifier = Modifier.alpha(0.5f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text = place,
                    modifier = Modifier.alpha(0.5f),
                )
            }

        }
        Spacer(modifier = Modifier.height(18.dp))

    }


}