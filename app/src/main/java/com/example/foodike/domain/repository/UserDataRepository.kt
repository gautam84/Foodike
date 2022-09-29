package com.example.foodike.domain.repository

import com.example.foodike.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    suspend fun updateLikedRestaurant(restaurant: Set<String>)
    suspend fun getLikedRestaurants(): Flow<List<Restaurant>>

}