package com.example.foodike.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    fun getRestaurantFromName(name: String): Restaurant? {
        return repository.getRestaurantFromName(name)
    }
}