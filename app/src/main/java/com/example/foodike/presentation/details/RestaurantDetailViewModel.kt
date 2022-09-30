package com.example.foodike.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.data.repository.Results
import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.CartRepository
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import com.example.foodike.presentation.cart.CartState
import com.example.foodike.presentation.login.LoginEvent
import com.example.foodike.presentation.login.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _detailScreenState = mutableStateOf(DetailScreenState())
    val detailScreenState: State<DetailScreenState> = _detailScreenState


    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.SetRestaurant -> {
                viewModelScope.launch {
                    _detailScreenState.value = detailScreenState.value.copy(
                        restaurant = repository.getRestaurantFromName(event.restaurant),
                    )
                    cartRepository.setCartItems(repository.getRestaurantFromName(event.restaurant)!!)
                    cartRepository.getCartItems().collect {
                        _detailScreenState.value = detailScreenState.value.copy(
                            menuList = it
                        )
                    }
                    userDataRepository.getLikedRestaurants().collect {
                        _detailScreenState.value = detailScreenState.value.copy(
                            isLiked = it.contains(repository.getRestaurantFromName(event.restaurant)!!)
                        )
                    }
                }
            }
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


        }
    }




    fun increaseQuantity(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.increaseQuantity(cartItem)
        }
    }

    fun decreaseQuantity(cartItem: CartItem) {
        viewModelScope.launch {
            cartRepository.decreaseQuantity(cartItem)
        }
    }







//
//
//    fun setLikeStatus(restaurant: Restaurant) {
//        _isLiked.value = list.contains(restaurant)
//
//    }
//
//    fun addRestaurant(restaurant: Restaurant) {
//        if (!list.contains(restaurant)) {
//            list.add(restaurant)
//        }
//
//        val nameList = mutableListOf<String>()
//
//        list.forEach {
//            nameList.add(it.name)
//        }
//
//        viewModelScope.launch {
//            userDataRepository.updateLikedRestaurant(nameList.toSet())
//        }
//
//    }
//
//    fun removeRestaurant(restaurant: Restaurant) {
//        if (list.contains(restaurant)) {
//            list.remove(restaurant)
//        }
//
//
//        val nameList = mutableListOf<String>()
//
//        list.forEach {
//            nameList.add(it.name)
//        }
//
//        viewModelScope.launch {
//            userDataRepository.updateLikedRestaurant(nameList.toSet())
//        }
//
//    }


}


