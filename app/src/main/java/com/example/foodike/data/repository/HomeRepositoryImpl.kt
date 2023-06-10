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

package com.example.foodike.data.repository

import com.example.foodike.data.data_source.adList
import com.example.foodike.data.data_source.recommendedList
import com.example.foodike.data.data_source.restaurantList
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository

class HomeRepositoryImpl() : HomeRepository {

    override suspend fun getRestaurants(): Results<List<Restaurant>> {
        return Results.Success(restaurantList)
    }

    override suspend fun getAds(): Results<List<Advertisement>> {
        return Results.Success(adList)
    }

    override suspend fun getFoodItems(): Results<List<FoodItem>> {
        return Results.Success(recommendedList)
    }

    override fun getRestaurantFromName(name: String): Restaurant? {
        return restaurantList.find {
            it.name == name
        }
    }
}