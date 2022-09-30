package com.example.foodike.presentation.details

sealed class DetailScreenEvent {
    data class SetRestaurant(val restaurant: String) : DetailScreenEvent()
    object ToggleRecommendedSectionExpandedState : DetailScreenEvent()
    object ToggleNonVegSectionExpandedState : DetailScreenEvent()
    object ToggleVegSectionExpandedState : DetailScreenEvent()


}