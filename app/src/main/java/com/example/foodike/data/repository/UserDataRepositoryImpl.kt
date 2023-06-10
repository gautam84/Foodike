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

import com.example.foodike.data.data_source.cartList
import com.example.foodike.data.data_source.favouriteList
import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



class UserDataRepositoryImpl : UserDataRepository {

    private val menuList = mutableSetOf<CartItem>()
    private val cartListItems = cartList.toMutableList()
    private var currentRestaurant: Restaurant? = null


    override suspend fun setRestaurant(restaurant: Restaurant) {
        currentRestaurant = restaurant
        restaurant.menu.forEach {
            menuList.add(CartItem(it, 0))
        }
    }

    override suspend fun getSavedRestaurant(): Flow<Restaurant> = flow {
        if (currentRestaurant != null) {
            emit(currentRestaurant!!)
        }
    }

    override suspend fun getMenuItems(): Flow<List<CartItem>> = flow {
        emit(menuList.toMutableList())
    }

    var list = favouriteList.toMutableList()


    override suspend fun getLikedRestaurants(): Flow<List<Restaurant>> = flow {
        emit(list)
    }

    override suspend fun isRestaurantLiked(restaurant: Restaurant): Flow<Boolean> = flow {
        emit(list.contains(restaurant))
    }

    override suspend fun getCartItems(): Flow<List<CartItem>> = flow {
        emit(cartListItems)
    }
}