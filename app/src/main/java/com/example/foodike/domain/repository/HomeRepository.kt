package com.example.foodike.domain.repository

import com.example.foodike.data.repository.Results
import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant

interface HomeRepository {

    suspend fun getRestaurants() : Results<List<Restaurant>>
    suspend fun getAds(): Results<List<Advertisement>>
    suspend fun getFoodItems():Results<List<FoodItem>>
    fun getRestaurantFromName(name: String): Restaurant?
    
}