package com.example.foodike.presentation.details

import com.example.foodike.domain.model.CartItem

sealed class DetailScreenEvent {
    data class SetRestaurant(val restaurant: String) : DetailScreenEvent()
    object ToggleRecommendedSectionExpandedState : DetailScreenEvent()
    object ToggleNonVegSectionExpandedState : DetailScreenEvent()
    object ToggleVegSectionExpandedState : DetailScreenEvent()
    object ToggleLikedStatus : DetailScreenEvent()
    data class IncreaseCartQuantity(val cartItem: CartItem): DetailScreenEvent()
    data class  DecreaseCartQuantity(val cartItem: CartItem): DetailScreenEvent()



}