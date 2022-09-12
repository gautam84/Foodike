package com.example.foodike.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
) : ViewModel(){
    private val _cartState = mutableStateOf(
        CartState()
    )

    val cartState: State<CartState> = _cartState

    init {
        viewModelScope.launch{
            cartRepository.getCartItems().collect {
                _cartState.value = cartState.value.copy(
                    restaurant = null,
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
}