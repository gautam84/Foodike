package com.example.foodike.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository,

    ) : ViewModel() {

    private val _detailScreenState = mutableStateOf(DetailScreenState())
    val detailScreenState: State<DetailScreenState> = _detailScreenState

    init {
        viewModelScope.launch {
            userDataRepository.getMenuItems().collect {
                _detailScreenState.value = detailScreenState.value.copy(
                    menuList = it,
                    recommendedList = it.shuffled()
                        .dropLast(it.size - 5)
                )
            }

            userDataRepository.getSavedRestaurant().collect { restaurant ->
                _detailScreenState.value = detailScreenState.value.copy(
                    restaurant = restaurant,
                )
                userDataRepository.isRestaurantLiked(restaurant).collect {
                    _detailScreenState.value = detailScreenState.value.copy(
                        isLiked = it
                    )
                }

            }
        }
    }


    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.ToggleRecommendedSectionExpandedState -> {
                _detailScreenState.value = detailScreenState.value.copy(
                    recommendedExpandedState = !detailScreenState.value.recommendedExpandedState
                )
            }
            is DetailScreenEvent.ToggleNonVegSectionExpandedState -> {
                _detailScreenState.value = detailScreenState.value.copy(
                    nonVegExpandedState = !detailScreenState.value.nonVegExpandedState
                )
            }
            is DetailScreenEvent.ToggleVegSectionExpandedState -> {
                _detailScreenState.value = detailScreenState.value.copy(
                    vegExpandedState = !detailScreenState.value.vegExpandedState
                )
            }
            is DetailScreenEvent.ToggleLikedStatus -> {
                if (_detailScreenState.value.isLiked) {
                    _detailScreenState.value = detailScreenState.value.copy(
                        isLiked = false
                    )
                } else {
                    _detailScreenState.value = detailScreenState.value.copy(
                        isLiked = true
                    )
                }

            }
        }
    }
}


