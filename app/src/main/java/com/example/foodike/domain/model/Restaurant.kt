package com.example.foodike.domain.model

data class Restaurant(
    val name: String,
    val rating: Long,
    val timeInSeconds: Long,
    val variety: String,
    val place: String,
    val averagePrice: Long,
    val image: Int,
    val menu: List<MenuItem>
)
