package com.example.foodike.presentation.cart

import com.example.foodike.domain.model.CartItem
import com.example.foodike.presentation.details.DetailScreenEvent

sealed class CartEvent{
    data class IncreaseCartQuantity(val cartItem: CartItem): CartEvent()
    data class  DecreaseCartQuantity(val cartItem: CartItem): CartEvent()
}