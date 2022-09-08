package com.example.foodike.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    fun getRestaurantFromName(name: String): Restaurant? {
        return repository.getRestaurantFromName(name)
    }

    val list = mutableListOf<Restaurant>()

    private val _isLiked = mutableStateOf(false)
    val likedRestaurants: State<Boolean> = _isLiked

    init {
        getLikedRestaurants()
    }

    private fun getLikedRestaurants() {
        viewModelScope.launch {
            userDataRepository.getLikedRestaurants().collect {
                it.forEach { name ->
                    list.add(repository.getRestaurantFromName(name)!!)
                }
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