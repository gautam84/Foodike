package com.example.foodike.presentation.common

import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant

data class CartState(
    val restaurant: Restaurant? = null,
    val list: List<CartItem> = emptyList(),

    )
