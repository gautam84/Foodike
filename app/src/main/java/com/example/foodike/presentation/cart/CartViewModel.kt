package com.example.foodike.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.data.data_source.restaurantList
import com.example.foodike.domain.model.CartItem
import com.example.foodike.domain.repository.CartRepository
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _cartState = mutableStateOf(
        CartState()
    )

    val cartState: State<CartState> = _cartState

    init {
        viewModelScope.launch {
            cartRepository.getSavedRestaurant().collect { restaurant ->
                cartRepository.getCartItems(restaurant).collect {
                    _cartState.value = cartState.value.copy(
                        restaurant = restaurant,
                        list = it.toMutableList()
                    )
                }
            }

        }
    }

    fun onEvent(event: CartEvent) {
        when (event) {
            is CartEvent.IncreaseCartQuantity -> {
                viewModelScope.launch {
                    cartRepository.increaseQuantity(event.cartItem)
                }
            }
            is CartEvent.DecreaseCartQuantity -> {
                viewModelScope.launch {
                    cartRepository.decreaseQuantity(event.cartItem)
                }
            }

        }
    }


}