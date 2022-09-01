package com.example.foodike.presentation.home.util

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector


@Stable
class Filter(
    val name: String,
    enabled: Boolean = false,
    val icon: ImageVector? = null
) {
    val enabled = mutableStateOf(enabled)
}
val filters = listOf(
    Filter(name = "Fast Delivery"),
    Filter(name = "Great deals"),
    Filter(name = "Non-Veg"),
    Filter(name = "50% Discount"),
)