package com.example.foodike.data.repository

import androidx.compose.ui.graphics.Color
import com.example.foodike.R
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.MenuItem
import com.example.foodike.domain.model.Restaurant

val menu1 = listOf(
    MenuItem(
        dish = "Fish and Chips",
        price = 3.95,
        rating = 4.7,
        isVegetarian = false
    ),
    MenuItem(
        dish = "Guacamole with Chips and Salsa",
        price = 4.50,
        rating = 4.4,
        isVegetarian = false
    )
)

val menu2 = listOf(
    MenuItem(
        dish = "Fish and Chips",
        price = 3.95,
        rating = 4.7,
        isVegetarian = false
    ),
)

val menu3 = listOf(
    MenuItem(
        dish = "Fish and Chips",
        price = 3.95,
        rating = 4.7,
        isVegetarian = false
    ),
)

val restaurantList = listOf(
    Restaurant(
        name = "George Street",
        rating = 4.6,
        noOfRatings = 128,
        timeInMillis = 3540000,
        variety = "American",
        place = "Mahabhairab",
        averagePrice = 3.0,
        image = R.drawable.applepie,
        menu = menu1
    ),
    Restaurant(
        name = "KF",
        rating = 4.9,
        noOfRatings = 567,
        timeInMillis = 3540000,
        variety = "American",
        place = "Mahabhairab",
        averagePrice = 4.5,
        image = R.drawable.applepie,
        menu = menu1
    )

)

val adList = listOf(
    Advertisement(
        title = "Offers for you",
        subTitle = "Upto 20% discount for you",
        color = Color(0xFFE89191),
        image = R.drawable.chinese_bowl
    ),
    Advertisement(
        title = "Free delivery",
        subTitle = "Free delivery for selected restaurants",
        color = Color(0xFFDBE891),
        image = R.drawable.rider
    )

)