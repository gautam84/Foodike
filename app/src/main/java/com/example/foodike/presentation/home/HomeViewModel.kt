/**
 *
 *	MIT License
 *
 *	Copyright (c) 2023 Gautam Hazarika
 *
 *	Permission is hereby granted, free of charge, to any person obtaining a copy
 *	of this software and associated documentation files (the "Software"), to deal
 *	in the Software without restriction, including without limitation the rights
 *	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *	copies of the Software, and to permit persons to whom the Software is
 *	furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all
 *	copies or substantial portions of the Software.
 *
 *	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *	SOFTWARE.
 *
 **/

package com.example.foodike.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.data.repository.Results
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository,

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
                    restaurantList = result.data,
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

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.SelectRestaurant -> {
                viewModelScope.launch {
                    userDataRepository.setRestaurant(event.restaurant)
                    event.onClick()
                }
            }
        }
    }


}