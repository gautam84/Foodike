package com.example.foodike.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.R
import com.example.foodike.data.repository.Results
import com.example.foodike.data.repository.successOr
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import com.example.foodike.presentation.login.FoodikeTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    private val _homeScreenState = mutableStateOf(
        HomeScreenState()
    )
    val homeScreenState: State<HomeScreenState> = _homeScreenState

    init {
        viewModelScope.launch {

            when (val result = repository.getAds()) {
                is Results.Success -> _homeScreenState.value = homeScreenState.value.copy(
                    adsList = result.data
                )
                is Results.Error -> {

                }
            }

            when (val result = repository.getFoodItems()) {
                is Results.Success -> _homeScreenState.value = homeScreenState.value.copy(
                    foodList = result.data
                )
                is Results.Error -> {

                }
            }

            when (val result = repository.getRestaurants()) {
                is Results.Success -> _homeScreenState.value = homeScreenState.value.copy(
                    restaurantList = result.data
                )
                is Results.Error -> {

                }
            }

            userDataRepository.getLikedRestaurants().collect {
                _homeScreenState.value = homeScreenState.value.copy(
                    likedRestaurantList = it
                )

            }

        }


    }


}