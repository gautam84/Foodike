package com.example.foodike.presentation.details

import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant

data class DetailScreenState(
    val restaurant: Restaurant? = null,
    val recommendedExpandedState: Boolean = true,
    val nonVegExpandedState: Boolean = true,
    val vegExpandedState: Boolean = true,
    val isLiked: Boolean = false,
    val menuList: List<CartItem> = emptyList()
)
