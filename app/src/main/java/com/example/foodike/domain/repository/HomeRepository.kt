package com.example.foodike.domain.repository

import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant

interface HomeRepository {

    suspend fun getRestaurants() : Result<List<Restaurant>>
    suspend fun getAds(): Result<List<Advertisement>>
    suspend fun getFoodItems():Result<List<FoodItem>>
    
}