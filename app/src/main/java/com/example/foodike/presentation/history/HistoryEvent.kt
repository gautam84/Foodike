package com.example.foodike.presentation.history

import com.example.foodike.domain.model.Restaurant

sealed class HistoryEvent {
    data class SelectRestaurant(val restaurant: Restaurant, val onClick: () -> Unit) :
        HistoryEvent()
}