package com.example.foodike.presentation.home.util

enum class Filter(val value: String) {
    FASTDELIVERY("Fast Delivery"),
    DISCOUNT("50% Discount"),
    GREATDEALS("Great deals"),
    NONVEG("Non-Veg")

}

fun getAllTags(): List<Filter> {
    return listOf(
        Filter.FASTDELIVERY, Filter.DISCOUNT, Filter.GREATDEALS,
        Filter.NONVEG
    )
}

fun getTag(value: String): Filter? {
    val map = Filter.values().associateBy(Filter::value)
    return map[value]
}

