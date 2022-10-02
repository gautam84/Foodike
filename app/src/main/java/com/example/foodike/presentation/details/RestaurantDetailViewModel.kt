package com.example.foodike.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.domain.repository.CartRepository
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _detailScreenState = mutableStateOf(DetailScreenState())
    val detailScreenState: State<DetailScreenState> = _detailScreenState

    init {
        viewModelScope.launch {

            cartRepository.getCartItems().collect {
                _detailScreenState.value = detailScreenState.value.copy(
                    menuList = it,
                    recommendedList = it.shuffled()
                    .dropLast(it.size - 5)
                )
            }

            cartRepository.getSavedRestaurant().collect { restaurant ->
                _detailScreenState.value = detailScreenState.value.copy(
                    restaurant = restaurant,
                )
                userDataRepository.getLikedRestaurants().collect { restaurantList ->
                    _detailScreenState.value = detailScreenState.value.copy(
                        isLiked = restaurantList.contains(
                            repository.getRestaurantFromName(
                                restaurant.name
                            )!!
                        )
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
                if (detailScreenState.value.isLiked) {
                    viewModelScope.launch {
                        userDataRepository.getLikedRestaurants().collect {
                            val likedList = it.toMutableList()
                            likedList.remove(detailScreenState.value.restaurant!!)
                            userDataRepository.updateLikedRestaurant(likedList.map { restaurant -> restaurant.name }
                                .toSet())
                        }
                    }
                } else {

                    viewModelScope.launch {
                        userDataRepository.getLikedRestaurants().collect {
                            val likedList = it.toMutableList()
                            likedList.add(detailScreenState.value.restaurant!!)
                            userDataRepository.updateLikedRestaurant(likedList.map { restaurant -> restaurant.name }
                                .toSet())
                        }
                    }
                }
            }
            is DetailScreenEvent.IncreaseCartQuantity -> {
                viewModelScope.launch {
                    cartRepository.increaseQuantity(event.cartItem)
                }
            }
            is DetailScreenEvent.DecreaseCartQuantity -> {
                viewModelScope.launch {
                    cartRepository.decreaseQuantity(event.cartItem)
                }
            }


        }
    }
}


