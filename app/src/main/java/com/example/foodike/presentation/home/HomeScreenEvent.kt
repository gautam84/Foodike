package com.example.foodike.presentation.home

import com.example.foodike.domain.model.Restaurant

sealed class HomeScreenEvent {
    data class SelectRestaurant(val restaurant: Restaurant, val onClick: () -> Unit) :
        HomeScreenEvent()
}