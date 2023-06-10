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


