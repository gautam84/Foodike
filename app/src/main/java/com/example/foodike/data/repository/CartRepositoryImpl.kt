package com.example.foodike.data.repository

import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class CartRepositoryImpl : CartRepository {

    private val cartList = MutableStateFlow<MutableSet<CartItem>>(mutableSetOf())
    private var currentRestaurant: Restaurant? = null


    override suspend fun setRestaurant(restaurant: Restaurant) {
        currentRestaurant = restaurant
    }

    override suspend fun getSavedRestaurant(): Flow<Restaurant> = flow {
        if (currentRestaurant != null) {
            emit(currentRestaurant!!)
        }
    }

    override suspend fun getCartItems(restaurant: Restaurant): Flow<List<CartItem>> = flow {
        restaurant.menu.forEach {
            cartList.value.add(CartItem(it, 0))
        }
        emit(cartList.value.toMutableList())
    }

    override suspend fun increaseQuantity(cartItem: CartItem) {
        cartList.value.map {
            if (it == cartItem) {
                it.noOfItems++
            }
        }

    }

    override suspend fun decreaseQuantity(cartItem: CartItem) {
        if (cartItem.noOfItems > 0) {
            cartList.value.map {
                if (it == cartItem) {
                    it.noOfItems--
                }
            }
        }
    }
}