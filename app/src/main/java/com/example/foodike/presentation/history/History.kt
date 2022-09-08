package com.example.foodike.presentation.history

import android.app.Activity
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.foodike.R
import com.example.foodike.data.data_source.menu2
import com.example.foodike.data.data_source.restaurantList
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.components.RestaurantCard
import com.example.foodike.presentation.components.SearchBar
import com.example.foodike.presentation.home.FavouriteSection
import com.example.foodike.presentation.util.Screen
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun History(
    viewModel: HistoryViewModel = hiltViewModel()
) {

    val list by viewModel.likedRestaurants


    val context = LocalContext.current as Activity

    val pagerState = rememberPagerState()


    context.window.statusBarColor = Color.Gray.toArgb()
    context.window.navigationBarColor = Color.White.toArgb()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(8.dp))

            Tabs(pagerState = pagerState)
        }
        TabsContent(pagerState = pagerState, list)

    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf("History", "Favourites")
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        modifier = Modifier.padding(0.dp, 0.dp, 75.dp, 0.dp),
        backgroundColor = Color.White,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 0.dp,
                color = Color.White
            )
        },

        ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        text = list[index],
                        fontSize = 20.sp,
                        fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Light,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Left
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }


            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState, list: List<Restaurant>) {

    HorizontalPager(count = 2, state = pagerState) { page ->
        when (page) {
            0 -> HistorySection()
            1 -> FavouritesSection(list = list)
        }
    }

}

@Composable
fun FavouritesSection(
    list: List<Restaurant>,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)

    ) {
        LazyColumn {

            items(list.size) {
                RestaurantCard(
                    restaurant = list[it],
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
//                            navController.navigate(Screen.RestaurantDetails.withArgs(list[it].name))
                        }
                )
            }

        }
    }
}

@Composable
fun HistorySection() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "HISTORYYY")
    }
}
