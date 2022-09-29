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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _cartState = mutableStateOf(
        CartState()
    )

    val cartState: State<CartState> = _cartState


    fun getRestaurantFromName(name: String): Restaurant? {

        loadCartList(name)
        return repository.getRestaurantFromName(name)
    }

    private fun loadCartList(
        name: String
    ) {
        viewModelScope.launch {
            cartRepository.setCartItems(repository.getRestaurantFromName(name)!!)
            cartRepository.getCartItems().collect {
                _cartState.value = cartState.value.copy(
                    restaurant = repository.getRestaurantFromName(name)!!,
                    list = it.toMutableList()
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


    var list = mutableListOf<Restaurant>()

    private val _isLiked = mutableStateOf(false)
    val likedRestaurants: State<Boolean> = _isLiked

    init {
        getLikedRestaurants()
    }

    private fun getLikedRestaurants() {
        viewModelScope.launch {
            userDataRepository.getLikedRestaurants().collect {
                list = it.toMutableList()
            }

        }
    }


    fun setLikeStatus(restaurant: Restaurant) {
        _isLiked.value = list.contains(restaurant)

    }

    fun addRestaurant(restaurant: Restaurant) {
        if (!list.contains(restaurant)) {
            list.add(restaurant)
        }

        val nameList = mutableListOf<String>()

        list.forEach {
            nameList.add(it.name)
        }

        viewModelScope.launch {
            userDataRepository.updateLikedRestaurant(nameList.toSet())
        }

    }

    fun removeRestaurant(restaurant: Restaurant) {
        if (list.contains(restaurant)) {
            list.remove(restaurant)
        }


        val nameList = mutableListOf<String>()

        list.forEach {
            nameList.add(it.name)
        }

        viewModelScope.launch {
            userDataRepository.updateLikedRestaurant(nameList.toSet())
        }

    }


}


