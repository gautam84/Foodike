package com.example.foodike.presentation.history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository
import com.example.foodike.domain.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val userDataRepository: UserDataRepository
) : ViewModel() {

    private val _likedRestaurants = mutableStateOf(mutableListOf<Restaurant>())
    val likedRestaurants: State<List<Restaurant>> = _likedRestaurants

    init {
        viewModelScope.launch {
            userDataRepository.getLikedRestaurants().collect {
                it.forEach { name ->
                    _likedRestaurants.value.add(repository.getRestaurantFromName(name)!!)
                }
            }

        }
    }

}