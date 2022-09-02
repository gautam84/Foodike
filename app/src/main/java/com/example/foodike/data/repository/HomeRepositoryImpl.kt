package com.example.foodike.data.repository

import com.example.foodike.domain.model.Advertisement
import com.example.foodike.domain.model.FoodItem
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.domain.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {

    override suspend fun getRestaurants(): Result<List<Restaurant>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAds(): Result<List<Advertisement>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFoodItems(): Result<List<FoodItem>> {
        TODO("Not yet implemented")
    }
}