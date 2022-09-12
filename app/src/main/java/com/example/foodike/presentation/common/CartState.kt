package com.example.foodike.presentation.common

import com.example.foodike.domain.model.MenuItem
import com.example.foodike.domain.model.Restaurant

data class CartState(
    val restaurant: Restaurant? = null,
    val list: MutableList<MenuItem> = mutableListOf()
)


