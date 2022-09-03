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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _ads = mutableStateOf(listOf<Advertisement>())
    val ads: State<List<Advertisement>> = _ads

    private val _restaurants = mutableStateOf(listOf<Restaurant>())
    val restaurants: State<List<Restaurant>> = _restaurants

    private val _food = mutableStateOf(listOf<FoodItem>())
    val food: State<List<FoodItem>> = _food

    init {
        loadAds()
        loadRestaurants()
        loadFoodItems()
    }

    private fun loadFoodItems() {
        viewModelScope.launch {
            viewModelScope.launch {

                when (val result = repository.getFoodItems()) {

                    is Results.Success -> _food.value = result.data
                    is Results.Error -> {

                    }
                }
            }
        }
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            viewModelScope.launch {

                when (val result = repository.getRestaurants()) {

                    is Results.Success -> _restaurants.value = result.data
                    is Results.Error -> {

                    }
                }
            }
        }

    }

    private fun loadAds() {
        viewModelScope.launch {

            when (val result = repository.getAds()) {

                is Results.Success -> _ads.value = result.data
                is Results.Error -> {

                }
            }
        }
    }

}