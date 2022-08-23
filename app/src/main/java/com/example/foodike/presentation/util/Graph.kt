package com.example.foodike.presentation.util

sealed class Graph(val route: String) {

    object Root : Graph(route = "root_graph")
    object Home :Graph(route = "home_graph")

}