package com.example.foodike.domain.repository

import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun setRestaurant(restaurant: Restaurant)
    suspend fun getSavedRestaurant(): Flow<Restaurant>
    suspend fun getCartItems(): Flow<List<CartItem>>
    suspend fun increaseQuantity(cartItem: CartItem)
    suspend fun decreaseQuantity(cartItem: CartItem)
}