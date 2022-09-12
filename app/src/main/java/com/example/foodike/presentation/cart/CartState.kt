package com.example.foodike.presentation.cart

import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.MenuItem
import com.example.foodike.domain.model.Restaurant

data class CartState(
    val restaurant: Restaurant? = null,
    val list: MutableList<CartItem> = mutableListOf()
)


