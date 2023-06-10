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

package com.example.foodike.data.data_source

import androidx.compose.ui.graphics.Color
import com.example.foodike.R
import com.example.foodike.domain.model.*

val menu1 = listOf(
    MenuItem(
        dish = "Fish and Chips",
        price = 3.95,
        rating = 4.7,
        noOfRatings = 12,
        isVegetarian = false
    ),
    MenuItem(
        dish = "Guacamole with Chips",
        price = 4.50,
        rating = 4.4,
        noOfRatings = 15,

        isVegetarian = true
    ),
    MenuItem(
        dish = "Chicken Biryani",
        price = 2.55,
        rating = 4.9,
        noOfRatings = 22,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Kadai Paneer",
        price = 3.55,
        rating = 3.9,
        noOfRatings = 52,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Veg Pulao",
        price = 5.00,
        rating = 4.2,
        noOfRatings = 23,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Smoked Pork",
        price = 3.75,
        rating = 4.8,
        noOfRatings = 56,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Veg Pakora",
        price = 3.75,
        rating = 2.9,
        noOfRatings = 43,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Cheese Omelette",
        price = 1.15,
        rating = 3.9,
        noOfRatings = 60,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Chicken Tikka Roll",
        price = 7.75,
        rating = 4.9,
        noOfRatings = 33,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Baby Corn",
        price = 2.00,
        rating = 3.9,
        noOfRatings = 55,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Veg Momo",
        price = 2.00,
        rating = 4.6,
        noOfRatings = 63,

        isVegetarian = true

    ),

    MenuItem(
        dish = "Chicken Momo",
        price = 3.50,
        rating = 4.9,
        noOfRatings = 80,

        isVegetarian = false

    ),

    MenuItem(
        dish = "Aloo Paratha",
        price = 1.00,
        rating = 2.9,
        noOfRatings = 17,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Mutton Pulao",
        price = 7.75,
        rating = 2.9,
        noOfRatings = 15,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Prawns Chilli",
        price = 5.75,
        rating = 3.5,
        noOfRatings = 17,

        isVegetarian = false

    ),
    MenuItem(
        dish = "Veg Fried Rice",
        price = 3.75,
        rating = 4.1,
        noOfRatings = 42,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Prawn Fried Rice",
        price = 6.75,
        rating = 4.9,
        noOfRatings = 52,

        isVegetarian = false

    ),
)

val menu2 = listOf(
    MenuItem(
        dish = "Masala Dosa",
        price = 4.50,
        rating = 4.4,
        noOfRatings = 73,

        isVegetarian = true
    ),
    MenuItem(
        dish = "Papdi Chaat",
        price = 2.55,
        rating = 4.9,
        noOfRatings = 33,

        isVegetarian = true

    ),

    MenuItem(
        dish = "Chole Bhature",
        price = 3.75,
        rating = 4.8,
        noOfRatings = 53,

        isVegetarian = true

    ),

    MenuItem(
        dish = "Paw Bhaaji",
        price = 2.00,
        rating = 3.9,
        noOfRatings = 67,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Amrit Peda",
        price = 2.00,
        rating = 4.6,
        noOfRatings = 9,

        isVegetarian = true

    ),

    MenuItem(
        dish = "Pani Puchka",
        price = 3.50,
        rating = 4.9,
        noOfRatings = 93,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Raj Kachoori",
        price = 3.55,
        rating = 3.9,
        noOfRatings = 83,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Plain Dosa",
        price = 3.95,
        rating = 4.7,
        noOfRatings = 13,
        isVegetarian = true
    ),

    MenuItem(
        dish = "Vada Pav",
        price = 5.00,
        rating = 4.2,
        noOfRatings = 43,

        isVegetarian = true

    ),


    MenuItem(
        dish = "Kachori",
        price = 3.75,
        rating = 2.9,
        noOfRatings = 43,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Gond Ladoo",
        price = 1.15,
        rating = 3.9,
        noOfRatings = 66,

        isVegetarian = true

    ),
    MenuItem(
        dish = "Raskadam",
        price = 7.75,
        rating = 4.9,
        noOfRatings = 13,

        isVegetarian = true

    ),

    MenuItem(
        dish = "Aloo Paratha",
        price = 1.00,
        rating = 2.9,
        noOfRatings = 23,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Samosa Chat",
        price = 7.75,
        rating = 2.9,
        noOfRatings = 21,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Aloo Tikki",
        price = 5.75,
        rating = 3.5,
        noOfRatings = 88,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Veg Fried Rice",
        price = 3.75,
        rating = 4.1,
        noOfRatings = 78,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Butter Masala Dosa",
        price = 6.75,
        rating = 4.9,
        noOfRatings = 31,
        isVegetarian = true

    ),
)

val menu3 = listOf(
    MenuItem(
        dish = "Szechwan Chilli Chicken",
        price = 6.75,
        rating = 4.9,
        noOfRatings = 31,
        isVegetarian = false
    ),
    MenuItem(
        dish = "Veg Momo",
        price = 2.00,
        rating = 4.6,
        noOfRatings = 13,
        isVegetarian = true

    ),

    MenuItem(
        dish = "Chicken Momo",
        price = 3.50,
        rating = 4.9,
        noOfRatings = 71,
        isVegetarian = false

    ),

    MenuItem(
        dish = "Aloo Paratha",
        price = 1.00,
        rating = 2.9,
        noOfRatings = 23,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Mutton Pula0",
        price = 7.75,
        rating = 2.9,
        noOfRatings = 13,
        isVegetarian = false

    ),
    MenuItem(
        dish = "Prawns Chilli",
        price = 5.75,
        rating = 3.5,
        noOfRatings = 75,
        isVegetarian = false

    ),
    MenuItem(
        dish = "Veg Fried Rice",
        price = 3.75,
        rating = 4.1,
        noOfRatings = 73,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Veg Momo",
        price = 2.00,
        rating = 4.6,
        noOfRatings = 23,
        isVegetarian = true

    ),

    MenuItem(
        dish = "Chicken Momo",
        price = 3.50,
        rating = 4.9,
        noOfRatings = 13,
        isVegetarian = false

    ),

    MenuItem(
        dish = "Aloo Paratha",
        price = 1.00,
        rating = 2.9,
        noOfRatings = 23,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Mutton Pula0",
        price = 7.75,
        rating = 2.9,
        noOfRatings = 57,
        isVegetarian = false

    ),
    MenuItem(
        dish = "Prawns Chilli",
        price = 5.75,
        rating = 3.5,
        noOfRatings = 23,
        isVegetarian = false

    ),
    MenuItem(
        dish = "Veg Fried Rice",
        price = 3.75,
        rating = 4.1,
        noOfRatings = 13,
        isVegetarian = true

    ),
    MenuItem(
        dish = "Masala Dosa",
        price = 4.50,
        rating = 4.4,
        noOfRatings = 77,

        isVegetarian = true
    ),
    MenuItem(
        dish = "Papdi Chaat",
        price = 2.55,
        rating = 4.9,
        noOfRatings = 79,
        isVegetarian = true

    ),

    MenuItem(
        dish = "Chole Bhature",
        price = 3.75,
        rating = 4.8,
        noOfRatings = 45,
        isVegetarian = true

    ),

    MenuItem(
        dish = "Paw Bhaaji",
        price = 2.00,
        rating = 3.9,
        noOfRatings = 23,
        isVegetarian = true
    ),
    MenuItem(
        dish = "Amrit Peda",
        price = 2.00,
        rating = 4.6,
        noOfRatings = 81,
        isVegetarian = true

    ),

    MenuItem(
        dish = "Pani Puchka",
        price = 3.50,
        rating = 4.9,
        noOfRatings = 32,
        isVegetarian = true

    ),

    )


val restaurantList = listOf(
    Restaurant(
        name = "George Street",
        rating = 4.6,
        noOfRatings = 128,
        timeInMillis = 3540000,
        variety = "Indian, American",
        place = "Mahabhairab",
        averagePrice = 3.0,
        image = R.drawable.applepie,
        menu = menu1
    ),
    Restaurant(
        name = "Magnolia",
        rating = 4.3,
        noOfRatings = 257,
        timeInMillis = 2100000,
        variety = "North Indian",
        place = "Ketekibari",
        averagePrice = 2.0,
        image = R.drawable.dosa,
        menu = menu2
    ),
    Restaurant(
        name = "Saffron Xpress",
        rating = 3.6,
        noOfRatings = 79,
        timeInMillis = 2580000,
        variety = "Chinese",
        place = "Mission Charali",
        averagePrice = 3.5,
        image = R.drawable.chinese,
        menu = menu3
    ),
    Restaurant(
        name = "KF",
        rating = 4.9,
        noOfRatings = 357,
        timeInMillis = 3300000,
        variety = "North Indian, Vegetarian",
        place = "B.P. Tiniali",
        averagePrice = 4.0,
        image = R.drawable.burger,
        menu = menu3
    ),
    Restaurant(
        name = "Inaya Mughlai",
        rating = 2.6,
        noOfRatings = 221,
        timeInMillis = 1380000,
        variety = "Tandoori, American",
        place = "Goroimari",
        averagePrice = 2.0,
        image = R.drawable.biryani,
        menu = menu2
    ),
    Restaurant(
        name = "Edona",
        rating = 3.3,
        noOfRatings = 207,
        timeInMillis = 3060000,
        variety = "Italian",
        place = "Mission Charali",
        averagePrice = 7.0,
        image = R.drawable.paratha,
        menu = menu1
    ),
    Restaurant(
        name = "Relish",
        rating = 3.9,
        noOfRatings = 258,
        timeInMillis = 1800000,
        variety = "American, French",
        place = "Misamari",
        averagePrice = 1.0,
        image = R.drawable.pizza,
        menu = menu2
    ),
    Restaurant(
        name = "Lazziz",
        rating = 4.8,
        noOfRatings = 157,
        timeInMillis = 2340000,
        variety = "South Indian, French",
        place = "Jamuguri",
        averagePrice = 4.0,
        image = R.drawable.biryani,
        menu = menu2
    ),


    Restaurant(
        name = "Kanha",
        rating = 3.6,
        noOfRatings = 108,
        timeInMillis = 3540000,
        variety = "Chinese, Italian",
        place = "Jalukbari",
        averagePrice = 2.5,
        image = R.drawable.paratha,
        menu = menu3
    ),


    Restaurant(
        name = "Tandoori Hub",
        rating = 2.3,
        noOfRatings = 457,
        timeInMillis = 3240000,
        variety = "North Indian, South Indian",
        place = "Padum Pukhuri",
        averagePrice = 3.5,
        image = R.drawable.pizza,
        menu = menu2
    ),
    Restaurant(
        name = "Cafe Lighton",
        rating = 1.6,
        noOfRatings = 28,
        timeInMillis = 3540000,
        variety = "Indian",
        place = "Gauli Gaon",
        averagePrice = 2.0,
        image = R.drawable.dosa,
        menu = menu3
    ),
    Restaurant(
        name = "Hermes Kitchen",
        rating = 2.3,
        noOfRatings = 357,
        timeInMillis = 1500000,
        variety = "French, Italian",
        place = "Dekargaon",
        averagePrice = 4.5,
        image = R.drawable.applepie,
        menu = menu1
    ),


    Restaurant(
        name = "Eurus Hub",
        rating = 4.1,
        noOfRatings = 1128,
        timeInMillis = 1740000,
        variety = "Snacks",
        place = "Porua Charali",
        averagePrice = 3.5,
        image = R.drawable.chinese,
        menu = menu2
    ),
    Restaurant(
        name = "Naga Kitchen",
        rating = 4.2,
        noOfRatings = 1257,
        timeInMillis = 2100000,
        variety = "South Indian",
        place = "Mazgaon",
        averagePrice = 2.5,
        image = R.drawable.paratha,
        menu = menu1
    ),


    Restaurant(
        name = "99 Reasons to Eat",
        rating = 4.6,
        noOfRatings = 1028,
        timeInMillis = 1140000,
        variety = "Tandoori, Chinese",
        place = "Chandmari",
        averagePrice = 1.5,
        image = R.drawable.burger,
        menu = menu1
    ),
    Restaurant(
        name = "Rock n Rolls",
        rating = 2.9,
        noOfRatings = 237,
        timeInMillis = 3480000,
        variety = "French, Snacks",
        place = "Paasmile",
        averagePrice = 4.5,
        image = R.drawable.pizza,
        menu = menu3
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
    ),
    Advertisement(
        title = "Order groceries",
        subTitle = "Order groceries from local vendors",
        color = Color(0xFF91CEE8),
        image = R.drawable.groceries
    ),
    Advertisement(
        title = "Pay with UPI",
        subTitle = "Get extra 15% discount with UPI payment",
        color = Color(0xFFA791E8),
        image = R.drawable.upi

    )

)

val recommendedList = listOf(
    FoodItem(
        image = R.drawable.pizza,
        name = "Pizza"
    ),
    FoodItem(
        image = R.drawable.biryani,
        name = "Biryani"
    ),
    FoodItem(
        image = R.drawable.burger,
        name = "Burger"
    ),
    FoodItem(
        image = R.drawable.chinese,
        name = "Chinese"
    ),
    FoodItem(
        image = R.drawable.applepie,
        name = "Apple Pie"
    ),
    FoodItem(
        image = R.drawable.paratha,
        name = "Paratha"
    ),
    FoodItem(
        image = R.drawable.dosa,
        name = "Dosa"
    ),
)

val favouriteList = listOf(
    Restaurant(
        name = "George Street",
        rating = 4.6,
        noOfRatings = 128,
        timeInMillis = 3540000,
        variety = "Indian, American",
        place = "Mahabhairab",
        averagePrice = 3.0,
        image = R.drawable.applepie,
        menu = menu1
    ),
    Restaurant(
        name = "Saffron Xpress",
        rating = 3.6,
        noOfRatings = 79,
        timeInMillis = 2580000,
        variety = "Chinese",
        place = "Mission Charali",
        averagePrice = 3.5,
        image = R.drawable.chinese,
        menu = menu3
    ),
    Restaurant(
        name = "KF",
        rating = 4.9,
        noOfRatings = 357,
        timeInMillis = 3300000,
        variety = "North Indian, Vegetarian",
        place = "B.P. Tiniali",
        averagePrice = 4.0,
        image = R.drawable.burger,
        menu = menu3
    ),
    Restaurant(
        name = "Inaya Mughlai",
        rating = 2.6,
        noOfRatings = 221,
        timeInMillis = 1380000,
        variety = "Tandoori, American",
        place = "Goroimari",
        averagePrice = 2.0,
        image = R.drawable.biryani,
        menu = menu2
    ),
    Restaurant(
        name = "Edona",
        rating = 3.3,
        noOfRatings = 207,
        timeInMillis = 3060000,
        variety = "Italian",
        place = "Mission Charali",
        averagePrice = 7.0,
        image = R.drawable.paratha,
        menu = menu1
    ),
)

val cartList = listOf(
    CartItem(
        MenuItem(
            dish = "Paw Bhaaji",
            price = 2.00,
            rating = 3.9,
            noOfRatings = 23,
            isVegetarian = true
        ),
        1
    ),
    CartItem(
        MenuItem(
            dish = "Veg Pulao",
            price = 5.00,
            rating = 4.2,
            noOfRatings = 23,

            isVegetarian = true

        ),
        2
    )
)


