package com.example.foodike.presentation.history

import com.example.foodike.domain.model.Restaurant

data class HistoryState(
    val likedRestaurantList: List<Restaurant> = emptyList(),
)
