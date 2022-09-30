package com.example.foodike.domain.repository

import com.example.foodike.data.repository.Results
import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.MenuItem
import com.example.foodike.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun setCartItems(restaurant: Restaurant)
    suspend fun getCartItems(): Flow<List<CartItem>>
    suspend fun increaseQuantity(cartItem: CartItem)
    suspend fun decreaseQuantity(cartItem: CartItem)
}